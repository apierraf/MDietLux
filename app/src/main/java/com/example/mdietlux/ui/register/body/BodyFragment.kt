package com.example.mdietlux.ui.register.body

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mdietlux.R
import com.example.mdietlux.adapter.BodyAdapter
import com.example.mdietlux.data.model.body.DataBody
import com.example.mdietlux.data.network.WebAccess
import com.example.mdietlux.utils.ItemClick
import com.github.appintro.SlidePolicy
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class BodyFragment : Fragment(), SlidePolicy {

    lateinit var recyclerBody: RecyclerView
    lateinit var progressDialog: AlertDialog
    var sex = ""
    var bodyTypes = ""
    lateinit var pref :SharedPreferences

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_body, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pref = activity?.getSharedPreferences("myPref", Context.MODE_PRIVATE)!!

        recyclerBody = view.findViewById(R.id.rvBody)
        recyclerBody.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        progressDialog = ProgressDialog(view.context)
        progressDialog.setMessage("Cargando")
        progressDialog.show()

        loadBody()
    }

    fun loadBody() {
        // Launch Kotlin Coroutine on Android's main thread
        GlobalScope.launch(Dispatchers.Main) {
            // Execute web request through coroutine call adapter & retrofit
            val webResponse = WebAccess.partsApi.getBodyTypes().await()
            if (!webResponse.data.isNullOrEmpty()) {
                progressDialog.dismiss()

                sex = pref.getString("sex","").toString()
                val listTemp: MutableList<DataBody> = mutableListOf()

                webResponse.data.map {
                    if (it.sex == sex) {
                        listTemp.add(it)

                        recyclerBody.adapter = activity?.let { it1 ->
                            BodyAdapter(it1.applicationContext, listTemp.toList(), object : ItemClick {
                                override fun clicked(pos: Int) {

                                    bodyTypes = listTemp[pos].id.toString()
                                    val editor = pref.edit()
                                    editor?.putString("body_types", bodyTypes)
                                    editor?.apply()

                                    val test = pref.getString("body_types","")
                                    //Toast.makeText(activity!!.applicationContext,test,Toast.LENGTH_LONG).show()

                                }
                            })
                        }
                    }
                }
            }
        }
    }

    override val isPolicyRespected: Boolean
        get() = bodyTypes.isNotEmpty()

    override fun onUserIllegallyRequestedNextPage() {
        Toast.makeText(activity?.applicationContext, "Seleccione un tipo de cuerpo", Toast.LENGTH_LONG).show()
    }
}