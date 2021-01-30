package com.example.mdietlux.ui.dasboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mdietlux.R
import com.example.mdietlux.data.model.resume.DataBody
import com.example.mdietlux.data.network.WebAccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DasboardViewModel : ViewModel() {

    var seccion = MutableLiveData<String>()
    var heigth: MutableLiveData<String> = MutableLiveData()
    var age: MutableLiveData<String> = MutableLiveData()
    var weigth: MutableLiveData<String> = MutableLiveData()
    var ageMeta: MutableLiveData<String> = MutableLiveData()
    var firstWeek: MutableLiveData<String> = MutableLiveData()
    var water: MutableLiveData<String> = MutableLiveData()
    var imcData: MutableLiveData<String> = MutableLiveData()
    var imcNotification: MutableLiveData<String> = MutableLiveData()
    var sex: MutableLiveData<String> = MutableLiveData()
    var percentPerson: MutableLiveData<String> = MutableLiveData()


    fun loadResume(dataBody: DataBody) {
        // Launch Kotlin Coroutine on Android's main thread
        GlobalScope.launch(Dispatchers.Main) {
            // Execute web request through coroutine call adapter & retrofit
            val webResponse = WebAccess.partsApi.getResume(dataBody).await()

            sex.value = webResponse.data?.sex

            /* seccion.apply {
                 this.value = webResponse.data.
             }*/

            (webResponse.data?.high + " cm").also {
                heigth.apply {
                    this.value = it
                }
            }
            age.apply {
                this.value = webResponse.data?.years
            }
            (webResponse.data?.currentWeight + " kg").also {
                weigth.apply {
                    this.value = it
                }

                ageMeta.apply {
                    this.value = webResponse.data?.metabolicAge.toString()
                }

                (webResponse.data?.let {
                    String.format(
                        "%.1f",
                        it.weightLossFirstWeek
                    )
                } + " kg").also {
                    firstWeek.apply {
                        this.value = it
                    }
                }

                (webResponse.data?.let { String.format("%.1f", it.waterLitres) } + " L").also {
                    water.apply {
                        this.value = it
                    }
                }
                imcData.apply {
                    this.value = webResponse.data?.imc.toString()
                }
                imcNotification.apply {
                    this.value = webResponse.data?.imcState
                }
                (webResponse.data?.percentageOfEffectiveness.toString() + "%").also {
                    percentPerson.apply {
                        this.value = it
                    }
                }
            }
        }
    }
}