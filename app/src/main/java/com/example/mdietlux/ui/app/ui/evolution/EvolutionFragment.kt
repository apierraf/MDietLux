package com.example.mdietlux.ui.app.ui.evolution

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.afollestad.materialdialogs.customview.getCustomView
import com.example.mdietlux.R
import com.example.mdietlux.data.model.evolution.post.PostEvolution
import com.example.mdietlux.data.network.WebAccess
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.marcinmoskala.arcseekbar.ArcSeekBar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class EvolutionFragment : Fragment() {

    private lateinit var dashboardViewModel: EvolutionViewModel

    lateinit var current_weight: TextInputEditText
    lateinit var neck: TextInputEditText
    lateinit var arm: TextInputEditText
    lateinit var chest: TextInputEditText
    lateinit var hip: TextInputEditText
    lateinit var calf: TextInputEditText
    lateinit var thigh: TextInputEditText
    lateinit var exercises: AutoCompleteTextView
    var idexerci = 0
    lateinit var pref: SharedPreferences
    lateinit var email:String

    lateinit var btnEvaluation: MaterialButton

    lateinit var progressDialog: AlertDialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(EvolutionViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_evolution, container, false)
        /* val textView: TextView = root.findViewById(R.id.text_dashboard)
         dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
             textView.text = it
         })*/
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        current_weight = view.findViewById(R.id.current_weight)
        neck = view.findViewById(R.id.neck)
        arm = view.findViewById(R.id.arm)
        chest = view.findViewById(R.id.chest)
        hip = view.findViewById(R.id.hip)
        calf = view.findViewById(R.id.calf)
        thigh = view.findViewById(R.id.thigh)
        exercises = view.findViewById(R.id.exercises)

        pref = activity?.getSharedPreferences("myPref", Context.MODE_PRIVATE)!!

        email = pref.getString("username", "").toString()

        val items = listOf(
            "Casi nada",
            "A menudo salgo a caminar",
            "Ejercicio 1-2 veces por semana",
            "Ejercicio 3-5 veces por semana",
            "Ejercicio 5-7 veces por semana"
        )
        val adapter = ArrayAdapter(requireContext(), R.layout.list_item, items)
        exercises.setAdapter(adapter)
        exercises.setOnItemClickListener { parent, view, position, id ->
            idexerci = position + 1
            //Toast.makeText(this.context, idexerci.toString(), Toast.LENGTH_LONG).show()
        }

        progressDialog = ProgressDialog(view.context)
        progressDialog.setMessage("Cargando")

        btnEvaluation = view.findViewById(R.id.evaluation)

        btnEvaluation.setOnClickListener {
            getData()
        }

    }

    fun getData() {
        progressDialog.show()
        GlobalScope.launch(Dispatchers.Main) {
            // Execute web request through coroutine call adapter & retrofit
            val webResponse = WebAccess.partsApi.postEvolution(
                PostEvolution(
                    current_weight.text.toString().toInt(),
                    neck.text.toString().toInt(),
                    arm.text.toString().toInt(),
                    chest.text.toString().toInt(),
                    hip.text.toString().toInt(),
                    calf.text.toString().toInt(),
                    thigh.text.toString().toInt(),
                    idexerci
                ), email
            ).await()
            if (!webResponse.imcState?.isEmpty()!!){
                progressDialog.dismiss()

                this@EvolutionFragment.context?.let {
                    MaterialDialog(it).show {
                        customView(R.layout.dialog_evaluation)
                        this.title(text = "Evolución")
                        this.view.setBackgroundColor(Color.DKGRAY)
                        val ark = this.findViewById<ArcSeekBar>(R.id.seekArcD)
                        ark.progress = webResponse.imc!!.toInt()

                        val imct = this.findViewById<TextView>(R.id.imcDataD)
                        imct.text = webResponse.imc.toString()

                        val noti = this.findViewById<TextView>(R.id.imcNotificationD)
                        noti.text = webResponse.imcState

                        positiveButton {
                            dismiss()
                        }
                    }
                }
            }
        }
    }
}