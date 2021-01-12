package com.example.mdietlux.data.network

import android.util.Log
import com.example.mdietlux.utils.Constants
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object WebAccess {

    val partsApi: PartsApiClient by lazy {

        Log.d("WebAccess", "Creating retrofit client")
        val retrofit = Retrofit.Builder()

            .baseUrl("https://mdietlux.com/api/")
            // Moshi maps JSON to classes
            .addConverterFactory(MoshiConverterFactory.create())
            // The call adapter handles threads
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(OkHttpClient.Builder().addInterceptor { chain ->
                val request = chain.request().newBuilder().addHeader("Authorization", "Bearer ${Constants.TOKEN}" ).build()
                chain.proceed(request)
            }.build())
            .build()
        // Create Retrofit client
        return@lazy retrofit.create(PartsApiClient::class.java)
    }
}