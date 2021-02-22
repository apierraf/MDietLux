package com.example.mdietlux.data.model.evolution.get


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class X1X(
    @Json(name = "calf")
    val calf: Int?,
    @Json(name = "week")
    val week: Int?
)