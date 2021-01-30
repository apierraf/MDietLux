package com.example.mdietlux.ui.onboarding

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.mdietlux.R
import com.example.mdietlux.ui.dasboard.DasboardActivity
import com.example.mdietlux.ui.register.body.BodyFragment
import com.example.mdietlux.ui.register.countries.CountriesFragment
import com.example.mdietlux.ui.register.day.TypicalDaysFragment
import com.example.mdietlux.ui.register.energies.EnergiesFragment
import com.example.mdietlux.ui.register.exercices.ExercicesFragment
import com.example.mdietlux.ui.register.gender.GenderFragment
import com.example.mdietlux.ui.register.habits.HabitsFragment
import com.example.mdietlux.ui.register.measure.MeasureFragment
import com.example.mdietlux.ui.register.objetives.ObjetivesFragment
import com.example.mdietlux.ui.register.sleeping.SleepingFragment
import com.example.mdietlux.ui.register.waters.WatersFragment
import com.github.appintro.AppIntro2

class OnBoardingApp : AppIntro2() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Make sure you don't call setContentView!

        // Call addSlide passing your Fragments.
        // You can use AppIntroFragment to use a pre-built fragment
        addSlide(GenderFragment())
        addSlide(CountriesFragment())
        addSlide(ObjetivesFragment())
        addSlide(MeasureFragment())
        addSlide(BodyFragment())
        addSlide(TypicalDaysFragment())
        addSlide(HabitsFragment())
        addSlide(ExercicesFragment())
        addSlide(EnergiesFragment())
        addSlide(SleepingFragment())
        addSlide(WatersFragment())

        isWizardMode = true
        showStatusBar(true)

        // Control the status bar color
        setStatusBarColorRes(R.color.green_700)

        isIndicatorEnabled = true

        // Change Indicator Color
        setIndicatorColor(
            selectedIndicatorColor = Color.GREEN,
            unselectedIndicatorColor = Color.DKGRAY
        )

        // Switch from Dotted Indicator to Progress Indicator
        setProgressIndicator()

    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        // Decide what to do when the user clicks on "Skip"
        finish()
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        // Decide what to do when the user clicks on "Done"
        val intent = Intent(this, DasboardActivity::class.java)
        startActivity(intent)
        finish()
    }

}