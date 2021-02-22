package com.example.mdietlux.data.model.evolution.get


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CaloriesForWeightLoss(
    @Json(name = "calories")
    val calories: Double?,
    @Json(name = "max")
    val max: Double?,
    @Json(name = "min")
    val min: Double?,
    @Json(name = "percent")
    val percent: Double?
)