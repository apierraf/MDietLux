package com.example.mdietlux.ui.register.countries

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
import com.example.mdietlux.adapter.CountriesAdapter
import com.example.mdietlux.data.network.WebAccess
import com.example.mdietlux.utils.ItemClick
import com.github.appintro.SlidePolicy
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class CountriesFragment : Fragment(), SlidePolicy {

    lateinit var recyclerCountries: RecyclerView
    lateinit var progressDialog: AlertDialog
    var country = ""
    lateinit var pref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_countries, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pref = activity?.getSharedPreferences("myPref", Context.MODE_PRIVATE)!!

        recyclerCountries = view.findViewById(R.id.rvCountries)
        progressDialog = ProgressDialog(view.context)
        progressDialog.setMessage("Cargando")
        progressDialog.show()
        loadCountries()

    }

    fun loadCountries() {
        // Launch Kotlin Coroutine on Android's main thread
        GlobalScope.launch(Dispatchers.Main) {
            // Execute web request through coroutine call adapter & retrofit
            val webResponse = WebAccess.partsApi.getCountries().await()
            if (!webResponse.data.isNullOrEmpty()) {
                progressDialog.dismiss()
            }
            recyclerCountries.adapter =
                webResponse.data?.let {
                    activity?.let { it1 ->
                        CountriesAdapter(
                            it1.applicationContext,
                            it, object : ItemClick {
                                override fun clicked(pos: Int) {

                                    country = it[pos].id.toString()
                                    val editor = pref?.edit()
                                    editor?.putString("country", country)
                                    editor?.apply()

                                    val test = pref.getString("country","")
                                    Toast.makeText(activity!!.applicationContext,test,Toast.LENGTH_LONG).show()
                                }
                            })
                    }
                }
            recyclerCountries.layoutManager = LinearLayoutManager(
                activity?.applicationContext,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }
    }

    override val isPolicyRespected: Boolean
        get() = country.isNotEmpty()

    override fun onUserIllegallyRequestedNextPage() {
        Toast.makeText(activity?.applicationContext, "Seleccione un país", Toast.LENGTH_LONG).show()
    }
}