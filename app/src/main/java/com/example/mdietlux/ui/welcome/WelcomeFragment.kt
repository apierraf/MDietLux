package com.example.mdietlux.ui.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import com.example.mdietlux.R
import com.google.android.material.button.MaterialButton


class WelcomeFragment : Fragment() {

    lateinit var btnStart: MaterialButton
    lateinit var txtRegister: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnStart = view.findViewById(R.id.materialButton)
        btnStart.setOnClickListener {

            view.findNavController().navigate(R.id.action_welcomeFragment_to_genderFragment)
        }

        txtRegister = view.findViewById(R.id.txtRegister)
        txtRegister.setOnClickListener {
            view.findNavController().navigate(R.id.action_welcomeFragment_to_loginFragment)
        }
    }
}