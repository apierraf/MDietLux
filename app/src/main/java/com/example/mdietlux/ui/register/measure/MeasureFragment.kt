package com.example.mdietlux.ui.register.measure

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mdietlux.R
import com.example.mdietlux.ui.dialog.DialogAge
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MeasureFragment : Fragment() {

    lateinit var ageEditText: TextInputEditText
    lateinit var dialogAge: DialogAge

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_measure, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dialogAge = DialogAge(view.context)
        ageEditText = view.findViewById(R.id.inputAge)
        ageEditText.keyListener = null
        ageEditText.setOnClickListener {
            dialogAge.dialogShow()
        }
    }
}