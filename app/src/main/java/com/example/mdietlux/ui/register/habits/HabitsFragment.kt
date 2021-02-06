package com.example.mdietlux.ui.register.habits

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mdietlux.R
import com.example.mdietlux.adapter.AdapterHabit
import com.example.mdietlux.adapter.DayAdapter
import com.example.mdietlux.data.network.WebAccess
import com.example.mdietlux.utils.ItemClick
import com.github.appintro.SlidePolicy
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HabitsFragment : Fragment(), SlidePolicy {

    lateinit var recyclerHabit: RecyclerView
    lateinit var progressDialog: AlertDialog

    var habits = ""
    lateinit var pref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_habits, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pref = activity?.getSharedPreferences("myPref", Context.MODE_PRIVATE)!!
        recyclerHabit = view.findViewById(R.id.rvHabit)
        progressDialog = ProgressDialog(view.context)
        progressDialog.setMessage("Cargando")
        progressDialog.show()

        loadHabits()

        recyclerHabit.layoutManager = LinearLayoutManager(
            activity?.applicationContext,
            LinearLayoutManager.VERTICAL,
            false
        )
    }

    fun loadHabits() {
        // Launch Kotlin Coroutine on Android's main thread
        GlobalScope.launch(Dispatchers.Main) {
            // Execute web request through coroutine call adapter & retrofit
            val webResponse = WebAccess.partsApi.getHabit().await()
            if (!webResponse.data.isNullOrEmpty()) {
                progressDialog.dismiss()
            }
            recyclerHabit.adapter = AdapterHabit(view?.context!!, webResponse.data!!, object :
                ItemClick {
                override fun clicked(pos: Int) {
                    habits = webResponse.data[pos].id.toString()
                    val editor = pref.edit()
                    editor?.putString("habits", habits)
                    editor?.apply()

                    val test = pref.getString("habits","")
                    Toast.makeText(activity!!.applicationContext,test,Toast.LENGTH_LONG).show()
                }
            })
        }
    }

    override val isPolicyRespected: Boolean
        get() = habits.isNotEmpty()

    override fun onUserIllegallyRequestedNextPage() {
        Toast.makeText(activity?.applicationContext, "Seleccione un hábito", Toast.LENGTH_LONG).show()
    }
}