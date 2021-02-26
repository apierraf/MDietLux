package com.example.mdietlux.ui.register.day

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
import com.example.mdietlux.adapter.DayAdapter
import com.example.mdietlux.data.network.WebAccess
import com.example.mdietlux.utils.ItemClick
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TypicalDaysFragment : Fragment() {

    lateinit var recyclerdays: RecyclerView
    lateinit var progressDialog: AlertDialog
    var day = ""
    lateinit var pref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_typical_days, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pref = activity?.getSharedPreferences("myPref", Context.MODE_PRIVATE)!!

        recyclerdays = view.findViewById(R.id.rvDays)
        progressDialog = ProgressDialog(view.context)
        progressDialog.setMessage("Cargando")
        progressDialog.show()

        loadDays()

        recyclerdays.layoutManager = LinearLayoutManager(
            activity?.applicationContext,
            LinearLayoutManager.VERTICAL,
            false
        )
    }

    fun loadDays() {
        // Launch Kotlin Coroutine on Android's main thread
        GlobalScope.launch(Dispatchers.Main) {
            // Execute web request through coroutine call adapter & retrofit
            val webResponse = WebAccess.partsApi.getTypicalDay().await()
            if (!webResponse.data.isNullOrEmpty()) {
                progressDialog.dismiss()
            }
            recyclerdays.adapter = DayAdapter(view?.context!!, webResponse.data!!, object :
                ItemClick {
                override fun clicked(pos: Int) {

                    day = webResponse.data[pos].id.toString()
                    val editor = pref.edit()
                    editor?.putString("day", day)
                    editor?.apply()

                    val test = pref.getString("day","")
                    //Toast.makeText(activity!!.applicationContext,test,Toast.LENGTH_LONG).show()
                    view!!.findNavController().navigate(R.id.action_typicalDaysFragment_to_habitsFragment)

                }
            })
        }
    }
}