package com.example.mdietlux.ui.app.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mdietlux.data.model.diet.DietSchedule
import com.example.mdietlux.data.network.WebAccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    var dietScheduleList : MutableLiveData<List<DietSchedule>> = MutableLiveData()

    fun loadData(){
        GlobalScope.launch(Dispatchers.Main) {
            // Execute web request through coroutine call adapter & retrofit
            val webResponse = WebAccess.partsApi.getDiet(1,"eros1cu@gmail.com").await()
            dietScheduleList.value = webResponse.dietSchedules


        }
    }
}