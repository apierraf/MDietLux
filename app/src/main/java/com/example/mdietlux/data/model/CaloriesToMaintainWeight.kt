package com.example.mdietlux.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CaloriesToMaintainWeight(
    @Json(name = "calories")
    val calories: Double?,
    @Json(name = "max")
    val max: Int?,
    @Json(name = "min")
    val min: Int?,
    @Json(name = "percent")
    val percent: Double?
)