package com.example.mdietlux.ui.register.objetives

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mdietlux.R
import com.example.mdietlux.adapter.CountriesAdapter
import com.example.mdietlux.adapter.ObjetiveAdapter
import com.example.mdietlux.data.network.WebAccess
import com.example.mdietlux.utils.ItemClick
import com.github.appintro.SlidePolicy
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ObjetivesFragment : Fragment(), SlidePolicy {

    lateinit var recyclerObjetives: RecyclerView
    lateinit var progressDialog: AlertDialog
    var objetives = ""
    lateinit var pref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_objetives, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pref = activity?.getSharedPreferences("myPref", Context.MODE_PRIVATE)!!

        recyclerObjetives = view.findViewById(R.id.rvObjetive)
        progressDialog = ProgressDialog(view.context)
        progressDialog.setMessage("Cargando")
        progressDialog.show()

        recyclerObjetives.layoutManager = LinearLayoutManager(
            activity?.applicationContext,
            LinearLayoutManager.VERTICAL,
            false
        )

        loadObjetives()
    }

    fun loadObjetives() {
        // Launch Kotlin Coroutine on Android's main thread
        GlobalScope.launch(Dispatchers.Main) {
            // Execute web request through coroutine call adapter & retrofit
            val webResponse = WebAccess.partsApi.getObjetives().await()
            if (!webResponse.data.isNullOrEmpty()) {
                progressDialog.dismiss()
            }
            recyclerObjetives.adapter =
                ObjetiveAdapter(view?.context!!, webResponse.data!!, object : ItemClick {
                    override fun clicked(pos: Int) {

                        objetives = webResponse.data[pos].id.toString()
                        val editor = pref.edit()
                        editor?.putString("objetives", objetives)
                        editor?.apply()

                        val test = pref.getString("objetives","")
                       // Toast.makeText(activity!!.applicationContext,test,Toast.LENGTH_LONG).show()
                    }
                })
        }
    }

    override val isPolicyRespected: Boolean
        get() = objetives.isNotEmpty()

    override fun onUserIllegallyRequestedNextPage() {
        Toast.makeText(activity?.applicationContext, "Seleccione un objetivo", Toast.LENGTH_LONG).show()
    }
}