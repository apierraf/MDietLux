package com.example.mdietlux.ui.register.gender

import android.content.Context
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mdietlux.R
import com.github.appintro.SlidePolicy

class GenderFragment : Fragment(), SlidePolicy {


    override val isPolicyRespected: Boolean
        get() = gender.isNotEmpty() // Your custom logic here.

    override fun onUserIllegallyRequestedNextPage() {
        Toast.makeText(activity?.applicationContext, "Seleccione un género", Toast.LENGTH_LONG).show()
    }

    lateinit var imageViewMale: ImageView
    lateinit var imageViewFemale: ImageView
    var gender = ""

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gender, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pref = activity?.getSharedPreferences("myPref", Context.MODE_PRIVATE)


        imageViewMale = view.findViewById(R.id.imageViewMale)
        imageViewFemale = view.findViewById(R.id.imageViewFemale)

        imageViewMale.setOnClickListener {

            gender = "male"


            val editor = pref?.edit()
            editor?.putString("sex", gender)
            editor?.apply()

           // Toast.makeText(view.context, pref?.getString("my-string",""), Toast.LENGTH_LONG).show()
            imageViewMale.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.green_500))
            imageViewFemale.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.five))
        }

        imageViewFemale.setOnClickListener {

            gender = "female"

            val editor = pref?.edit()
            editor?.putString("sex", gender)
            editor?.apply()

            //Toast.makeText(view.context, pref?.getString("my-string",""), Toast.LENGTH_LONG).show()
            imageViewFemale.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.green_500))
            imageViewMale.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.five))

        }

    }
}