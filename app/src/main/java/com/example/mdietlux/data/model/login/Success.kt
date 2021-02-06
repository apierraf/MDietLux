package com.example.mdietlux.data.model.login


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Success(
    @Json(name = "token")
    val token: String?
)