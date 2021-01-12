package com.example.mdietlux.data.model.resume


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeightLossFirstMonth(
    @Json(name = "month")
    val month: String?,
    @Json(name = "weight")
    val weight: Double?,
    @Json(name = "weightLossCoefficient")
    val weightLossCoefficient: Int?
)