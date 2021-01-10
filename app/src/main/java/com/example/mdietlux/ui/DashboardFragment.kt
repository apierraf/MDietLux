package com.example.mdietlux.ui

import android.app.AlertDialog
import android.app.ProgressDialog
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.mdietlux.R
import com.example.mdietlux.data.network.WebAccess
import com.marcinmoskala.arcseekbar.ArcSeekBar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch


class DashboardFragment : Fragment() {

    lateinit var sessionTextView: TextView
    lateinit var heigtTextView: TextView
    lateinit var ageTextView: TextView
    lateinit var weightTextView: TextView
    lateinit var ageMetaTextView: TextView
    lateinit var firstWeekTextView: TextView
    lateinit var watherTextView: TextView
    lateinit var arcSeekBar: ArcSeekBar
    lateinit var imcDataTextView: TextView
    lateinit var imcNotification: TextView
    lateinit var sexImageView: ImageView
    lateinit var percentPerson: TextView

    lateinit var progressDialog: AlertDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sessionTextView = view.findViewById(R.id.txtSession)
        heigtTextView = view.findViewById(R.id.heightData)
        ageTextView = view.findViewById(R.id.ageData)
        weightTextView = view.findViewById(R.id.weightData)
        ageMetaTextView = view.findViewById(R.id.ageMetabolism)
        firstWeekTextView = view.findViewById(R.id.firstWeek)
        watherTextView = view.findViewById(R.id.wather)
        imcDataTextView = view.findViewById(R.id.imcData)
        arcSeekBar = view.findViewById(R.id.seekArc)
        arcSeekBar.setProgressGradient(Color.GREEN, Color.YELLOW,Color.RED)
        imcNotification = view.findViewById(R.id.imcNotification)
        sexImageView = view.findViewById(R.id.sexLogo)
        percentPerson = view.findViewById(R.id.personPercent)

        progressDialog = ProgressDialog(view.context)

        loadResume()
    }

    fun loadResume() {
        // Launch Kotlin Coroutine on Android's main thread

        progressDialog.setMessage(getString(R.string.loading_data))
        progressDialog.show()

        GlobalScope.launch(Dispatchers.Main) {

            // Execute web request through coroutine call adapter & retrofit
            val webResponse = WebAccess.partsApi.getResume("prueba@gmail.com").await()

            if (webResponse.sex != null){

                progressDialog.hide()

                if (webResponse.sex == "male"){
                    sexImageView.setImageResource(R.drawable.ic_male)
                }else{
                    sexImageView.setImageResource(R.drawable.ic_female)
                }
                sessionTextView.text = webResponse.sessionId
                (webResponse.high + " cm").also { heigtTextView.text = it }
                ageTextView.text = webResponse.years
                (webResponse.currentWeight + " kg").also { weightTextView.text = it }
                ageMetaTextView.text = webResponse.metabolicAge.toString()
                (String.format("%.1f", webResponse.weightLossFirstWeek) + " kg").also { firstWeekTextView.text = it }
                (String.format("%.1f", webResponse.waterLitres) + " L").also { watherTextView.text = it }
                imcDataTextView.text = webResponse.imc.toString()
                arcSeekBar.progress = webResponse.imc!!.toDouble().toInt()
                imcNotification.text = webResponse.imcState
                (webResponse.percentageOfEffectiveness.toString() + "%").also { percentPerson.text = it }
            }
        }
    }
}