package com.example.mdietlux.data.network

import com.example.mdietlux.data.model.Resume
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface PartsApiClient {

    @GET("resume/{email}")
    fun getResume(@Path("email") email: String):
            Deferred<Resume>
}