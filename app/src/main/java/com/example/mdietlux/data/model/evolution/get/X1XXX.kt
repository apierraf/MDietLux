package com.example.mdietlux.data.model.evolution.get


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class X1XXX(
    @Json(name = "hip")
    val hip: Int?,
    @Json(name = "week")
    val week: Int?
)