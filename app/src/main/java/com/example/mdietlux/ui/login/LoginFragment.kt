package com.example.mdietlux.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import com.example.mdietlux.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class LoginFragment : Fragment() {

    lateinit var registerTextView: TextView
    lateinit var fbLogin: FloatingActionButton


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fbLogin = view.findViewById(R.id.button)
        fbLogin.setOnClickListener {
            view.findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)
        }

        registerTextView = view.findViewById(R.id.textView4)
        registerTextView.setOnClickListener {
            view.findNavController().navigate(R.id.action_loginFragment_to_onBoardingApp)
        }
    }

}