package com.example.mdietlux.ui.app.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.map
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mdietlux.R
import com.example.mdietlux.adapter.SectionFoodAdapter
import com.example.mdietlux.data.model.diet.DietSchedule
import com.example.mdietlux.data.model.diet.Food
import com.example.mdietlux.data.model.diet.SectionFood
import com.example.mdietlux.data.network.WebAccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.math.log


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    lateinit var rvSubject: RecyclerView
    lateinit var subjectAdapter: SectionFoodAdapter
    var subjects: ArrayList<SectionFood> = ArrayList()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        homeViewModel.loadData()

        homeViewModel.dietScheduleList.observe(viewLifecycleOwner, { list ->
            list.map {

                if (it.day == 1) {
                    val dayOne = SectionFood()
                    dayOne.id = 1
                    dayOne.subjectName = "Día 1"
                    dayOne.chapters = ArrayList()

                    val  breakfast = Food()
                    breakfast.chapterName = it.breakfast?.get(0)?.name
                    dayOne.chapters!!.add(breakfast)

                    val  morningSnack = Food()
                    morningSnack.chapterName = it.morningSnack?.get(0)?.name
                    dayOne.chapters!!.add(morningSnack)

                    subjects.add(dayOne)
                }

                if (it.day == 2) {
                    val dayTwo = SectionFood()
                    dayTwo.id = 1
                    dayTwo.subjectName = "Día 2"
                    dayTwo.chapters = ArrayList()

                    val chapter = Food()
                    chapter.chapterName = it.breakfast?.get(0)?.name
                    dayTwo.chapters!!.add(chapter)
                    subjects.add(dayTwo)
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

    private fun prepareData(): ArrayList<SectionFood> {

        val subjects: ArrayList<SectionFood> = ArrayList()

        val dayOne = SectionFood()
        dayOne.id = 1
        dayOne.subjectName = "Día 1"
        dayOne.chapters = ArrayList()

        val chapter = Food()
        chapter.chapterName = "pinga"
        dayOne.chapters!!.add(chapter)
        subjects.add(dayOne)

        val dayTwo = SectionFood()
        dayTwo.id = 2
        dayTwo.subjectName = "Día 2"
        dayTwo.chapters = ArrayList()

        dayTwo.chapters!!.add(chapter)
        dayTwo.chapters!!.add(chapter)
        dayTwo.chapters!!.add(chapter)
        dayTwo.chapters!!.add(chapter)
        dayTwo.chapters!!.add(chapter)
        dayTwo.chapters!!.add(chapter)
        dayTwo.chapters!!.add(chapter)

        subjects.add(dayTwo)

        val dayThree = SectionFood()
        dayThree.id = 3
        dayThree.subjectName = "Día 3"
        dayThree.chapters = ArrayList()

        dayThree.chapters!!.add(chapter)
        dayThree.chapters!!.add(chapter)
        dayThree.chapters!!.add(chapter)
        dayThree.chapters!!.add(chapter)
        dayThree.chapters!!.add(chapter)
        dayThree.chapters!!.add(chapter)

        subjects.add(dayThree)

        val dayFour = SectionFood()
        dayFour.id = 4
        dayFour.subjectName = "Día 4"
        dayFour.chapters = ArrayList()

        dayFour.chapters!!.add(chapter)
        dayFour.chapters!!.add(chapter)
        dayFour.chapters!!.add(chapter)
        dayFour.chapters!!.add(chapter)
        dayFour.chapters!!.add(chapter)
        dayFour.chapters!!.add(chapter)
        dayFour.chapters!!.add(chapter)
        dayFour.chapters!!.add(chapter)


        subjects.add(dayFour)

        val dayFive = SectionFood()
        dayFive.id = 5
        dayFive.subjectName = "Día 5"
        dayFive.chapters = ArrayList()

        dayFive.chapters!!.add(chapter)
        dayFive.chapters!!.add(chapter)
        dayFive.chapters!!.add(chapter)
        dayFive.chapters!!.add(chapter)
        dayFive.chapters!!.add(chapter)
        dayFive.chapters!!.add(chapter)
        dayFive.chapters!!.add(chapter)
        dayFive.chapters!!.add(chapter)
        dayFive.chapters!!.add(chapter)

        subjects.add(dayFive)

        val daySix = SectionFood()
        daySix.id = 6
        daySix.subjectName = "Día 6"
        daySix.chapters = ArrayList()

        daySix.chapters!!.add(chapter)
        daySix.chapters!!.add(chapter)
        daySix.chapters!!.add(chapter)
        daySix.chapters!!.add(chapter)
        daySix.chapters!!.add(chapter)
        daySix.chapters!!.add(chapter)
        daySix.chapters!!.add(chapter)

        subjects.add(daySix)

        val daySeven = SectionFood()
        daySeven.id = 7
        daySeven.subjectName = "Día 7"
        daySeven.chapters = ArrayList()

        daySeven.chapters!!.add(chapter)
        daySeven.chapters!!.add(chapter)
        daySeven.chapters!!.add(chapter)
        daySeven.chapters!!.add(chapter)
        daySeven.chapters!!.add(chapter)
        daySeven.chapters!!.add(chapter)
        daySeven.chapters!!.add(chapter)
        daySeven.chapters!!.add(chapter)

        subjects.add(daySeven)


        return subjects
    }
}