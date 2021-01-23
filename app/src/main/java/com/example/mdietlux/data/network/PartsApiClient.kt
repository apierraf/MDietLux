package com.example.mdietlux.data.network

import com.example.mdietlux.data.model.body.BodyTypes
import com.example.mdietlux.data.model.countries.Countries
import com.example.mdietlux.data.model.day.TypicalDays
import com.example.mdietlux.data.model.objetives.ObjetivesModel
import com.example.mdietlux.data.model.resume.Resume
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface PartsApiClient {

    @GET("resume/{email}")
    fun getResume(@Path("email") email: String):
            Deferred<Resume>

    @GET("countries")
    fun getCountries(): Deferred<Countries>

    @GET("objectives")
    fun getObjetives(): Deferred<ObjetivesModel>

    @GET("body-types")
    fun getBodyTypes(): Deferred<BodyTypes>

    @GET("typical-days")
    fun getTypicalDay(): Deferred<TypicalDays>
}