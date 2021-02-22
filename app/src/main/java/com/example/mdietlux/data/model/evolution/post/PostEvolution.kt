package com.example.mdietlux.data.model.evolution.post

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PostEvolution(
    @Json(name = "current_weight")
    val current_weight: Int?,

    @Json(name = "neck")
    val neck: Int?,

    @Json(name = "arm")
    val arm: Int?,

    @Json(name = "chest")
    val chest: Int?,

    @Json(name = "hip")
    val hip: Int?,

    @Json(name = "calf")
    val calf: Int?,

    @Json(name = "thigh")
    val thigh: Int?,

    @Json(name = "exercises")
    val exercises: Int?,
)

