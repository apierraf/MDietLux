package com.example.mdietlux.ui.splash

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.mdietlux.MainActivity
import com.example.mdietlux.R
import com.rbddevs.splashy.Splashy

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSplashy()
    }

    private fun setSplashy() {
        Splashy(this)
            .setLogo(R.drawable.ic_healthy_food)
            .setAnimation(Splashy.Animation.SLIDE_IN_TOP_BOTTOM,2000)
            .setTitleColor(R.color.black)
            .setFullScreen(yes = true)
            .setBackgroundResource(R.color.white)
            .setLogoWHinDp(250, 250)
            .setProgressColor(R.color.green_500)
            .setTitle(R.string.app_name)
            .setSubTitle(R.string.login_text_info)
            .setClickToHide(true)
            .setBackgroundColor(R.color.black)
            .setDuration(3000)
            .show()

        Splashy.onComplete(object : Splashy.OnComplete {
            override fun onComplete() {
                val intent: Intent = Intent(this@SplashActivity, MainActivity::class.java)
                this@SplashActivity.startActivity(intent)
            }

        })
    }
}