package com.example.mdietlux.data.model.resume


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeightLossStartMonth(
    @Json(name = "month")
    val month: String?,
    @Json(name = "weight")
    val weight: String?
)