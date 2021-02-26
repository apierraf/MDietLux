package com.example.mdietlux.ui.diet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.mdietlux.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.wajahatkarim3.easyvalidation.core.view_ktx.nonEmpty
import com.wajahatkarim3.easyvalidation.core.view_ktx.validEmail


class DietEmailFragment : Fragment() {

    lateinit var textInputLayout: TextInputLayout
    lateinit var textInputEditText: TextInputEditText
    lateinit var button: MaterialButton

    var email = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_diet_email, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textInputEditText = view.findViewById(R.id.user_email)
        textInputLayout = view.findViewById(R.id.textField)
        button = view.findViewById(R.id.btn_continue)

        button.setOnClickListener {
            /*  if (!email.validEmail() && !email.nonEmpty()){
                  textInputLayout.error = "Introduzca un email válido"
              }*/
            view.findNavController().navigate(R.id.action_dietEmailFragment_to_packeFragment)
        }
    }
}