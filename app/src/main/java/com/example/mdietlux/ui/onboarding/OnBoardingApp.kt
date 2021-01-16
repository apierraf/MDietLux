package com.example.mdietlux.ui.onboarding

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.mdietlux.R
import com.example.mdietlux.ui.register.countries.CountriesFragment
import com.example.mdietlux.ui.register.gender.GenderFragment
import com.github.appintro.AppIntro
import com.github.appintro.AppIntroFragment

class OnBoardingApp : AppIntro() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Make sure you don't call setContentView!

        // Call addSlide passing your Fragments.
        // You can use AppIntroFragment to use a pre-built fragment
        addSlide(GenderFragment())
        addSlide(CountriesFragment()
        )

        isWizardMode = true
        showStatusBar(true)

        // Control the status bar color
        setStatusBarColorRes(R.color.green_700)

        setIndicatorColor(
            selectedIndicatorColor = Color.WHITE,
            unselectedIndicatorColor = Color.WHITE,
        )

        setColorDoneText(Color.WHITE)

        //setNextArrowColor(Color.BLACK)
        setBarColor(resources.getColor(R.color.green_500))
    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        // Decide what to do when the user clicks on "Skip"
        finish()
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        // Decide what to do when the user clicks on "Done"
        finish()
    }
}