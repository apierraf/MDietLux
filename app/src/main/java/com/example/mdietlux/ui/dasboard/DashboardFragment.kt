package com.example.mdietlux.ui.dasboard

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.mdietlux.R
import com.example.mdietlux.data.model.resume.DataBody
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.marcinmoskala.arcseekbar.ArcSeekBar
import de.hdodenhof.circleimageview.CircleImageView


class DashboardFragment : Fragment() {

    lateinit var heigtTextView: TextView
    lateinit var ageTextView: TextView
    lateinit var weightTextView: TextView
    lateinit var ageMetaTextView: TextView
    lateinit var firstWeekTextView: TextView
    lateinit var waterTextView: TextView
    lateinit var arcSeekBar: ArcSeekBar
    lateinit var imcDataTextView: TextView
    lateinit var imcNotification: TextView
    lateinit var sexImageView: CircleImageView
    lateinit var percentPerson: TextView
    lateinit var progressDialog: AlertDialog
    lateinit var viewModel: DasboardViewModel
    lateinit var pref : SharedPreferences
    lateinit var scrollView: ScrollView
    lateinit var fab: ExtendedFloatingActionButton

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

        //sessionTextView = view.findViewById(R.id.txtSession)
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

        pref = activity?.getSharedPreferences("myPref", Context.MODE_PRIVATE)!!


        viewModel.loadResume(getPrefDataBody())

        progressDialog.show()
        progressDialog.setMessage("Cargando")

        fab = view.findViewById(R.id.fbDiet)
        fab.setOnClickListener {
            view.findNavController().navigate(R.id.action_dashboardFragment2_to_dietEmailFragment2)
        }
        scrollView = view.findViewById(R.id.scrollView2)

        scrollView.viewTreeObserver.addOnScrollChangedListener {
            val scrollX: Int = scrollView.scrollX //for horizontalScrollView
            val scrollY: Int = scrollView.scrollY //for verticalScrollView

            fab.isExtended = scrollY <= 0

        }
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

    }

    fun getPrefDataBody(): DataBody{

        return DataBody(
                pref.getString("sex", ""),
                "cosa",
                pref.getString("country", "")!!.toInt(),
                pref.getInt("age", 0),
                pref.getInt("heigth", 0),
                pref.getInt("weigth", 0),
                pref.getInt("weigthOBJ", 0),
                pref.getString("body_types", "")!!.toInt(),
                pref.getString("day", "")!!.toInt(),
                pref.getString("habits", "")!!.toInt(),
                pref.getString("exercices", "")!!.toInt(),
                pref.getString("energies", "")!!.toInt(),
                pref.getString("sleeping", "")!!.toInt(),
                pref.getString("water", "")!!.toInt(),
        )
    }
}