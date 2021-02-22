package com.example.mdietlux.ui.app.ui.home

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mdietlux.R
import com.example.mdietlux.adapter.SectionFoodAdapter
import com.example.mdietlux.data.model.diet.Food
import com.example.mdietlux.data.model.diet.SectionFood
import com.google.android.material.chip.Chip
import com.google.android.material.snackbar.Snackbar
import com.jaredrummler.materialspinner.MaterialSpinner


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    lateinit var rvSubject: RecyclerView
    lateinit var subjectAdapter: SectionFoodAdapter
    var subjects: ArrayList<SectionFood> = ArrayList()

    lateinit var pref: SharedPreferences
    lateinit var email:String

    lateinit var progressDialog: AlertDialog

    var week = 1



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        pref = activity?.getSharedPreferences("myPref", Context.MODE_PRIVATE)!!

        email = pref.getString("username", "").toString()

        progressDialog = ProgressDialog(root.context)
        progressDialog.setMessage("Cargando")
        progressDialog.show()

        val spinner = root.findViewById(R.id.spinner) as MaterialSpinner
        spinner.setItems("Semana 1", "Semana 2", "Semana 3", "Semana 4")
        spinner.setOnItemSelectedListener { view, position, id, item ->
            week = position + 1
            subjects.clear()
            homeViewModel.loadData(week, email)
        }

        homeViewModel.loadData(week, email)

        homeViewModel.dietScheduleList.observe(viewLifecycleOwner, { list ->

            if (list.isNotEmpty()){
                progressDialog.dismiss()
            }

            list.map { dietSchedule ->

                if (dietSchedule.day == 1) {
                    val dayOne = SectionFood()
                    dayOne.id = 1
                    dayOne.subjectName = "Día 1"
                    dayOne.chapters = ArrayList()

                    val breakfast = Food()
                    breakfast.chapterType = "Desayuno"
                    breakfast.chapterName = dietSchedule.breakfast?.get(0)?.name
                    breakfast.imageUrl = dietSchedule.breakfast?.get(0)?.image
                    dayOne.chapters!!.add(breakfast)

                    val morningSnack = Food()
                    morningSnack.chapterType = "Media mañana"
                    morningSnack.chapterName = dietSchedule.morningSnack?.get(0)?.name
                    morningSnack.imageUrl = dietSchedule.morningSnack?.get(0)?.image
                    dayOne.chapters!!.add(morningSnack)

                    dietSchedule.launch?.map {
                        val launch = Food()
                        launch.chapterType = "Comida"
                        launch.chapterName = it.name
                        launch.imageUrl = it.image
                        dayOne.chapters!!.add(launch)
                    }

                    val snack = Food()
                    snack.chapterType = "Merienda"
                    snack.chapterName = dietSchedule.snack?.get(0)?.name
                    snack.imageUrl = dietSchedule.snack?.get(0)?.image
                    dayOne.chapters!!.add(snack)

                    dietSchedule.dinner?.map {
                        val dinner = Food()
                        dinner.chapterType = "Cena"
                        dinner.chapterName = it.name
                        dinner.imageUrl = it.image
                        dayOne.chapters!!.add(dinner)
                    }

                    subjects.add(dayOne)
                }

                if (dietSchedule.day == 2) {
                    val dayTwo = SectionFood()
                    dayTwo.id = 1
                    dayTwo.subjectName = "Día 2"
                    dayTwo.chapters = ArrayList()
                    val breakfast = Food()
                    breakfast.chapterType = "Desayuno"
                    breakfast.chapterName = dietSchedule.breakfast?.get(0)?.name
                    breakfast.imageUrl = dietSchedule.breakfast?.get(0)?.image
                    dayTwo.chapters!!.add(breakfast)

                    val morningSnack = Food()
                    morningSnack.chapterType = "Media mañana"
                    morningSnack.chapterName = dietSchedule.morningSnack?.get(0)?.name
                    morningSnack.imageUrl = dietSchedule.morningSnack?.get(0)?.image
                    dayTwo.chapters!!.add(morningSnack)

                    dietSchedule.launch?.map {
                        val launch = Food()
                        launch.chapterType = "Comida"
                        launch.chapterName = it.name
                        launch.imageUrl = it.image
                        dayTwo.chapters!!.add(launch)
                    }

                    val snack = Food()
                    snack.chapterType = "Merienda"
                    snack.chapterName = dietSchedule.snack?.get(0)?.name
                    snack.imageUrl = dietSchedule.snack?.get(0)?.image
                    dayTwo.chapters!!.add(snack)

                    dietSchedule.dinner?.map {
                        val dinner = Food()
                        dinner.chapterType = "Cena"
                        dinner.chapterName = it.name
                        dinner.imageUrl = it.image
                        dayTwo.chapters!!.add(dinner)
                    }

                    subjects.add(dayTwo)


                }

                if (dietSchedule.day == 3) {
                    val dayThree = SectionFood()
                    dayThree.id = 1
                    dayThree.subjectName = "Día 3"
                    dayThree.chapters = ArrayList()

                    val breakfast = Food()
                    breakfast.chapterType = "Desayuno"
                    breakfast.chapterName = dietSchedule.breakfast?.get(0)?.name
                    breakfast.imageUrl = dietSchedule.breakfast?.get(0)?.image
                    dayThree.chapters!!.add(breakfast)

                    val morningSnack = Food()
                    morningSnack.chapterType = "Media mañana"
                    morningSnack.chapterName = dietSchedule.morningSnack?.get(0)?.name
                    morningSnack.imageUrl = dietSchedule.morningSnack?.get(0)?.image
                    dayThree.chapters!!.add(morningSnack)

                    dietSchedule.launch?.map {
                        val launch = Food()
                        launch.chapterType = "Comida"
                        launch.chapterName = it.name
                        launch.imageUrl = it.image
                        dayThree.chapters!!.add(launch)
                    }

                    val snack = Food()
                    snack.chapterType = "Merienda"
                    snack.chapterName = dietSchedule.snack?.get(0)?.name
                    snack.imageUrl = dietSchedule.snack?.get(0)?.image
                    dayThree.chapters!!.add(snack)

                    dietSchedule.dinner?.map {
                        val dinner = Food()
                        dinner.chapterType = "Cena"
                        dinner.chapterName = it.name
                        dinner.imageUrl = it.image
                        dayThree.chapters!!.add(dinner)
                    }

                    subjects.add(dayThree)


                }

                if (dietSchedule.day == 4) {
                    val dayFour = SectionFood()
                    dayFour.id = 1
                    dayFour.subjectName = "Día 4"
                    dayFour.chapters = ArrayList()

                    val breakfast = Food()
                    breakfast.chapterType = "Desayuno"
                    breakfast.chapterName = dietSchedule.breakfast?.get(0)?.name
                    breakfast.imageUrl = dietSchedule.breakfast?.get(0)?.image
                    dayFour.chapters!!.add(breakfast)

                    val morningSnack = Food()
                    morningSnack.chapterType = "Media mañana"
                    morningSnack.chapterName = dietSchedule.morningSnack?.get(0)?.name
                    morningSnack.imageUrl = dietSchedule.morningSnack?.get(0)?.image
                    dayFour.chapters!!.add(morningSnack)

                    dietSchedule.launch?.map {
                        val launch = Food()
                        launch.chapterType = "Comida"
                        launch.chapterName = it.name
                        launch.imageUrl = it.image
                        dayFour.chapters!!.add(launch)
                    }

                    val snack = Food()
                    snack.chapterType = "Merienda"
                    snack.chapterName = dietSchedule.snack?.get(0)?.name
                    snack.imageUrl = dietSchedule.snack?.get(0)?.image
                    dayFour.chapters!!.add(snack)

                    dietSchedule.dinner?.map {
                        val dinner = Food()
                        dinner.chapterType = "Cena"
                        dinner.chapterName = it.name
                        dinner.imageUrl = it.image
                        dayFour.chapters!!.add(dinner)
                    }

                    subjects.add(dayFour)


                }

                if (dietSchedule.day == 5) {
                    val dayFive = SectionFood()
                    dayFive.id = 1
                    dayFive.subjectName = "Día 5"
                    dayFive.chapters = ArrayList()

                    val breakfast = Food()
                    breakfast.chapterType = "Desayuno"
                    breakfast.chapterName = dietSchedule.breakfast?.get(0)?.name
                    breakfast.imageUrl = dietSchedule.breakfast?.get(0)?.image
                    dayFive.chapters!!.add(breakfast)

                    val morningSnack = Food()
                    morningSnack.chapterType = "Media mañana"
                    morningSnack.chapterName = dietSchedule.morningSnack?.get(0)?.name
                    morningSnack.imageUrl = dietSchedule.morningSnack?.get(0)?.image
                    dayFive.chapters!!.add(morningSnack)

                    dietSchedule.launch?.map {
                        val launch = Food()
                        launch.chapterType = "Comida"
                        launch.chapterName = it.name
                        launch.imageUrl = it.image
                        dayFive.chapters!!.add(launch)
                    }

                    val snack = Food()
                    snack.chapterType = "Merienda"
                    snack.chapterName = dietSchedule.snack?.get(0)?.name
                    snack.imageUrl = dietSchedule.snack?.get(0)?.image
                    dayFive.chapters!!.add(snack)

                    dietSchedule.dinner?.map {
                        val dinner = Food()
                        dinner.chapterType = "Cena"
                        dinner.chapterName = it.name
                        dinner.imageUrl = it.image
                        dayFive.chapters!!.add(dinner)
                    }

                    subjects.add(dayFive)


                }

                if (dietSchedule.day == 6) {
                    val daySix = SectionFood()
                    daySix.id = 1
                    daySix.subjectName = "Día 6"
                    daySix.chapters = ArrayList()

                    val breakfast = Food()
                    breakfast.chapterType = "Desayuno"
                    breakfast.chapterName = dietSchedule.breakfast?.get(0)?.name
                    breakfast.imageUrl = dietSchedule.breakfast?.get(0)?.image
                    daySix.chapters!!.add(breakfast)

                    val morningSnack = Food()
                    morningSnack.chapterType = "Media mañana"
                    morningSnack.chapterName = dietSchedule.morningSnack?.get(0)?.name
                    morningSnack.imageUrl = dietSchedule.morningSnack?.get(0)?.image
                    daySix.chapters!!.add(morningSnack)

                    dietSchedule.launch?.map {
                        val launch = Food()
                        launch.chapterType = "Comida"
                        launch.chapterName = it.name
                        launch.imageUrl = it.image
                        daySix.chapters!!.add(launch)
                    }

                    val snack = Food()
                    snack.chapterType = "Merienda"
                    snack.chapterName = dietSchedule.snack?.get(0)?.name
                    snack.imageUrl = dietSchedule.snack?.get(0)?.image
                    daySix.chapters!!.add(snack)

                    dietSchedule.dinner?.map {
                        val dinner = Food()
                        dinner.chapterType = "Cena"
                        dinner.chapterName = it.name
                        dinner.imageUrl = it.image
                        daySix.chapters!!.add(dinner)
                    }

                    subjects.add(daySix)

                }

                if (dietSchedule.day == 7) {
                    val daySeven = SectionFood()
                    daySeven.id = 1
                    daySeven.subjectName = "Día 7"
                    daySeven.chapters = ArrayList()

                    val breakfast = Food()
                    breakfast.chapterType = "Desayuno"
                    breakfast.chapterName = dietSchedule.breakfast?.get(0)?.name
                    breakfast.imageUrl = dietSchedule.breakfast?.get(0)?.image
                    daySeven.chapters!!.add(breakfast)

                    val morningSnack = Food()
                    morningSnack.chapterType = "Media mañana"
                    morningSnack.chapterName = dietSchedule.morningSnack?.get(0)?.name
                    morningSnack.imageUrl = dietSchedule.morningSnack?.get(0)?.image
                    daySeven.chapters!!.add(morningSnack)

                    dietSchedule.launch?.map {
                        val launch = Food()
                        launch.chapterType = "Comida"
                        launch.chapterName = it.name
                        launch.imageUrl = it.image
                        daySeven.chapters!!.add(launch)
                    }

                    val snack = Food()
                    snack.chapterType = "Merienda"
                    snack.chapterName = dietSchedule.snack?.get(0)?.name
                    snack.imageUrl = dietSchedule.snack?.get(0)?.image
                    daySeven.chapters!!.add(snack)

                    dietSchedule.dinner?.map {
                        val dinner = Food()
                        dinner.chapterType = "Cena"
                        dinner.chapterName = it.name
                        dinner.imageUrl = it.image
                        daySeven.chapters!!.add(dinner)
                    }

                    subjects.add(daySeven)

                }


                subjectAdapter = SectionFoodAdapter(subjects, root.context)

                rvSubject = root.findViewById(R.id.rvSubject)
                val manager = LinearLayoutManager(root.context)
                rvSubject.layoutManager = manager
                rvSubject.adapter = subjectAdapter


            }

        })

        return root
    }
}