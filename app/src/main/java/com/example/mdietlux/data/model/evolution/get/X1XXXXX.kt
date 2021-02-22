package com.example.mdietlux.data.model.evolution.get


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class X1XXXXX(
    @Json(name = "thigh")
    val thigh: Int?,
    @Json(name = "week")
    val week: Int?
)