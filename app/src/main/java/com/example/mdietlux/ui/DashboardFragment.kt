package com.example.mdietlux.ui

import android.app.AlertDialog
import android.app.ProgressDialog
import android.graphics.Color
import android.graphics.DashPathEffect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.mdietlux.R
import com.example.mdietlux.data.network.WebAccess
import com.example.mdietlux.utils.CustomMarker
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.LimitLine
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.github.mikephil.charting.utils.Utils
import com.marcinmoskala.arcseekbar.ArcSeekBar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
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
    lateinit var mChart: LineChart
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
        arcSeekBar.setProgressGradient(Color.GREEN, Color.YELLOW, Color.RED)
        imcNotification = view.findViewById(R.id.imcNotification)
        sexImageView = view.findViewById(R.id.sexLogo)
        percentPerson = view.findViewById(R.id.personPercent)

        progressDialog = ProgressDialog(view.context)

        mChart = view.findViewById(R.id.chart1)

        loadResume()

        setData()
    }

    fun loadResume() {
        // Launch Kotlin Coroutine on Android's main thread

        progressDialog.setMessage(getString(R.string.loading_data))
        progressDialog.show()

        GlobalScope.launch(Dispatchers.Main) {

            // Execute web request through coroutine call adapter & retrofit
            val webResponse = WebAccess.partsApi.getResume("prueba@gmail.com").await()

            if (webResponse.sex != null) {

                progressDialog.hide()

                if (webResponse.sex == "male") {
                    sexImageView.setImageResource(R.drawable.ic_male)
                } else {
                    sexImageView.setImageResource(R.drawable.ic_female)
                }
                sessionTextView.text = webResponse.sessionId
                (webResponse.high + " cm").also { heigtTextView.text = it }
                ageTextView.text = webResponse.years
                (webResponse.currentWeight + " kg").also { weightTextView.text = it }
                ageMetaTextView.text = webResponse.metabolicAge.toString()
                (String.format(
                    "%.1f",
                    webResponse.weightLossFirstWeek
                ) + " kg").also { firstWeekTextView.text = it }
                (String.format("%.1f", webResponse.waterLitres) + " L").also {
                    watherTextView.text = it
                }
                imcDataTextView.text = webResponse.imc.toString()
                arcSeekBar.progress = webResponse.imc!!.toDouble().toInt()
                imcNotification.text = webResponse.imcState
                (webResponse.percentageOfEffectiveness.toString() + "%").also {
                    percentPerson.text = it
                }
            }
        }
    }


    private fun setData() {
        //Part1
        val entries = ArrayList<Entry>()

        //Part2
        entries.add(Entry(1f, 90f))
        entries.add(Entry(2f, 70f))
        entries.add(Entry(3f, 50f))


        //Part3
        val vl = LineDataSet(entries, "My Type")
        //Part4
        vl.setDrawValues(false)
        vl.setDrawFilled(true)
        vl.lineWidth = 3f
        vl.fillColor = R.color.purple_700
        vl.fillAlpha = R.color.purple_200
        //Part5
        mChart.xAxis.labelRotationAngle = 0f
        //Part6
        mChart.data = LineData(vl)
        //Part7
        mChart.axisRight.isEnabled = false
        mChart.xAxis.axisMaximum = 3+0.1f
        //Part8
        mChart.setTouchEnabled(true)
        mChart.setPinchZoom(true)
        //Part9
        mChart.description.text = "Days"
        mChart.setNoDataText("No forex yet!")
        //Part10
        mChart.animateX(1800, Easing.EaseInCubic)
        //Part11
        val markerView = this.context?.let { CustomMarker(it, R.layout.marker_view) }
        mChart.marker = markerView
    }

}