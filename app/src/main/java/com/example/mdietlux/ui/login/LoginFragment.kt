package com.example.mdietlux.ui.login

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.mdietlux.R
import com.example.mdietlux.data.model.login.LoginPostModel
import com.example.mdietlux.data.network.WebAccess
import com.example.mdietlux.ui.app.AppUser
import com.example.mdietlux.ui.app.ui.home.HomeFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {

    lateinit var registerTextView: TextView
    lateinit var fbLogin: FloatingActionButton

    lateinit var userInput: TextInputEditText
    lateinit var passInput: TextInputEditText

    lateinit var progressDialog: AlertDialog

    lateinit var postModel: LoginPostModel

    lateinit var pref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userInput = view.findViewById(R.id.inputUser)
        passInput = view.findViewById(R.id.inputPass)

        pref = activity?.getSharedPreferences("myPref", Context.MODE_PRIVATE)!!

        progressDialog = ProgressDialog(view.context)


        fbLogin = view.findViewById(R.id.button)
        fbLogin.setOnClickListener {

            loginPost()
            //view.findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)

        }

    }

    fun loginPost() {

        val userString = userInput.text.toString()
        val passString = passInput.text.toString()

        postModel = LoginPostModel(userString, passString)

        GlobalScope.launch(Dispatchers.Main) {
            progressDialog.show()
            progressDialog.setMessage("Cargando")
            // Execute web request through coroutine call adapter & retrofit
            val webResponse = WebAccess.partsApi.postLogin(postModel).await()
            progressDialog.dismiss()
            //Toast.makeText(view?.context, webResponse.success?.token, Toast.LENGTH_LONG).show()
            if (!webResponse.success?.token.isNullOrEmpty()){
                val intent = Intent(this@LoginFragment.context, AppUser::class.java)
                val editor = pref.edit()
                editor?.putString("username", userString)
                editor?.apply()
                activity?.startActivity(intent)
            }
        }
    }
}