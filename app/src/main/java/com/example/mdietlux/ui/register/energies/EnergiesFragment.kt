package com.example.mdietlux.ui.register.energies

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mdietlux.R
import com.example.mdietlux.adapter.EnergiesAdapter
import com.example.mdietlux.data.network.WebAccess
import com.example.mdietlux.utils.ItemClick
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class EnergiesFragment : Fragment() {

    lateinit var recyclerEnergies: RecyclerView
    lateinit var progressDialog: AlertDialog

    var energies = ""
    lateinit var pref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_energies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pref = activity?.getSharedPreferences("myPref", Context.MODE_PRIVATE)!!
        recyclerEnergies = view.findViewById(R.id.rvEnergies)
        progressDialog = ProgressDialog(view.context)
        progressDialog.setMessage("Cargando")
        progressDialog.show()

        loadEnergies()

        recyclerEnergies.layoutManager = LinearLayoutManager(
            activity?.applicationContext,
            LinearLayoutManager.VERTICAL,
            false
        )
    }

    fun loadEnergies() {
        // Launch Kotlin Coroutine on Android's main thread
        GlobalScope.launch(Dispatchers.Main) {
            // Execute web request through coroutine call adapter & retrofit
            val webResponse = WebAccess.partsApi.getEnergies().await()
            if (!webResponse.data.isNullOrEmpty()) {
                progressDialog.dismiss()
            }
            recyclerEnergies.adapter = EnergiesAdapter(view?.context!!, webResponse.data!!, object :
                ItemClick {
                override fun clicked(pos: Int) {
                    energies = webResponse.data[pos].id.toString()
                    val editor = pref.edit()
                    editor?.putString("energies", energies)
                    editor?.apply()

                    val test = pref.getString("energies","")
                    //Toast.makeText(activity!!.applicationContext,test,Toast.LENGTH_LONG).show()
                    view!!.findNavController().navigate(R.id.action_energiesFragment_to_sleepingFragment)
                }
            })
        }
    }

}