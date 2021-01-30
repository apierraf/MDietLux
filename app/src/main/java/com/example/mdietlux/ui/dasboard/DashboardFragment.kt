package com.example.mdietlux.ui.dasboard

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
import androidx.lifecycle.ViewModelProvider
import com.example.mdietlux.R
import com.example.mdietlux.data.model.resume.DataBody
import com.example.mdietlux.data.network.WebAccess
import com.example.mdietlux.utils.CustomMarker
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.marcinmoskala.arcseekbar.ArcSeekBar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class DashboardFragment : Fragment() {

    //lateinit var sessionTextView: TextView
    lateinit var heigtTextView: TextView
    lateinit var ageTextView: TextView
    lateinit var weightTextView: TextView
    lateinit var ageMetaTextView: TextView
    lateinit var firstWeekTextView: TextView
    lateinit var waterTextView: TextView
    lateinit var arcSeekBar: ArcSeekBar
    lateinit var imcDataTextView: TextView
    lateinit var imcNotification: TextView
    lateinit var sexImageView: ImageView
    lateinit var percentPerson: TextView
    lateinit var mChart: LineChart
    lateinit var progressDialog: AlertDialog
    lateinit var viewModel: DasboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)
            .get(DasboardViewModel::class.java)

       // sessionTextView = view.findViewById(R.id.txtSession)
        heigtTextView = view.findViewById(R.id.heightData)
        ageTextView = view.findViewById(R.id.ageData)
        weightTextView = view.findViewById(R.id.weightData)
        ageMetaTextView = view.findViewById(R.id.ageMetabolism)
        firstWeekTextView = view.findViewById(R.id.firstWeek)
        waterTextView = view.findViewById(R.id.wather)
        imcDataTextView = view.findViewById(R.id.imcData)
        arcSeekBar = view.findViewById(R.id.seekArc)
        arcSeekBar.setProgressGradient(Color.GREEN, Color.YELLOW, Color.RED)
        imcNotification = view.findViewById(R.id.imcNotification)
        sexImageView = view.findViewById(R.id.sexLogo)
        percentPerson = view.findViewById(R.id.personPercent)

        progressDialog = ProgressDialog(view.context)
        progressDialog.show()

        mChart = view.findViewById(R.id.chart1)

        val dataBody = DataBody("male", "cosa", 1, 33, 160, 90, 100, 1, 1, 1, 1, 1, 1, 1)

        viewModel.loadResume(dataBody)

        progressDialog.show()
        progressDialog.setMessage("Cargando")

        /*viewModel.seccion.observe(viewLifecycleOwner, {
            if (it != null) {
                progressDialog.hide()
            }
            sessionTextView.text = it
        })*/

        viewModel.heigth.observe(viewLifecycleOwner, {
            if (it != null) {
                progressDialog.hide()
            }
            heigtTextView.text = it
        })

        viewModel.age.observe(viewLifecycleOwner, {
            ageTextView.text = it
        })

        viewModel.weigth.observe(viewLifecycleOwner, {
            weightTextView.text = it
        })

        viewModel.ageMeta.observe(viewLifecycleOwner, {
            ageMetaTextView.text = it
        })

        viewModel.firstWeek.observe(viewLifecycleOwner, {
            firstWeekTextView.text = it
        })

        viewModel.water.observe(viewLifecycleOwner, {
            waterTextView.text = it
        })

        viewModel.imcData.observe(viewLifecycleOwner, {
            imcDataTextView.text = it
            arcSeekBar.progress = it.toDouble().toInt()
        })

        viewModel.percentPerson.observe(viewLifecycleOwner, {
            percentPerson.text = it
        })

        viewModel.sex.observe(viewLifecycleOwner, {
            if (it == "male") {
                sexImageView.setImageResource(
                    R.drawable.ic_male
                )
            } else {
                sexImageView.setImageResource(R.drawable.ic_female)
            }
        })

        setData()
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
        vl.fillColor = R.color.teal_700
        vl.fillAlpha = R.color.teal_200
        //Part5
        mChart.xAxis.labelRotationAngle = 0f
        //Part6
        mChart.data = LineData(vl)
        //Part7
        mChart.axisRight.isEnabled = false
        mChart.xAxis.axisMaximum = 3 + 0.1f
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