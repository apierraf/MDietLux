package com.example.mdietlux.ui.register.gender

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.example.mdietlux.R
import com.github.appintro.SlidePolicy

class GenderFragment : Fragment(), SlidePolicy {

    override val isPolicyRespected: Boolean
        get() = gender.isNotEmpty() // Your custom logic here.

    override fun onUserIllegallyRequestedNextPage() {
        Toast.makeText(activity?.applicationContext, "Seleccione un género",Toast.LENGTH_LONG).show()
    }

    lateinit var imageViewMale: ImageView
    lateinit var imageViewFemale: ImageView
    var gender = String()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gender, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageViewMale = view.findViewById(R.id.imageViewMale)
        imageViewFemale = view.findViewById(R.id.imageViewFemale)

        imageViewMale.setOnClickListener {
            gender = "Male"
            Toast.makeText(view.context, gender, Toast.LENGTH_LONG).show()
            imageViewMale.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(R.color.green_500)))
            imageViewFemale.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(R.color.five)))
        }

        imageViewFemale.setOnClickListener {
            gender = "Female"
            Toast.makeText(view.context, gender, Toast.LENGTH_LONG).show()
            imageViewFemale.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(R.color.green_500)))
            imageViewMale.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(R.color.five)))
        }

    }

}