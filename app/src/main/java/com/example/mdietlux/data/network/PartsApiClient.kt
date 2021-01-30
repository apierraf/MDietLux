package com.example.mdietlux.data.network

import com.example.mdietlux.data.model.body.BodyTypes
import com.example.mdietlux.data.model.countries.Countries
import com.example.mdietlux.data.model.day.TypicalDays
import com.example.mdietlux.data.model.energies.Energies
import com.example.mdietlux.data.model.exercices.Exercices
import com.example.mdietlux.data.model.habits.Habit
import com.example.mdietlux.data.model.objetives.ObjetivesModel
import com.example.mdietlux.data.model.resume.DataBody
import com.example.mdietlux.data.model.resume.Resume
import com.example.mdietlux.data.model.sleeping.Sleeping
import com.example.mdietlux.data.model.waters.Waters
import kotlinx.coroutines.Deferred
import retrofit2.http.*

interface PartsApiClient {

    @POST("resume")
    fun getResume(@Body dataBody: DataBody):
            Deferred<Resume>

    @GET("countries")
    fun getCountries(): Deferred<Countries>

    @GET("objectives")
    fun getObjetives(): Deferred<ObjetivesModel>

    @GET("body-types")
    fun getBodyTypes(): Deferred<BodyTypes>

    @GET("typical-days")
    fun getTypicalDay(): Deferred<TypicalDays>

    @GET("habits")
    fun getHabit(): Deferred<Habit>

    @GET("exercises")
    fun getExercices(): Deferred<Exercices>

    @GET("energies")
    fun getEnergies(): Deferred<Energies>

    @GET("sleeping")
    fun getSleeping(): Deferred<Sleeping>

    @GET("waters")
    fun getWater(): Deferred<Waters>
}