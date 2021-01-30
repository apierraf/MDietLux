package com.example.mdietlux.data.model.resume

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class DataBody(
    @field:Json(name="sex")
    val sex: String?,

    @field:Json(name="email")
    val email: String?,

    @field:Json(name="country")
    val country: Int?,

    @field:Json(name="years")
    val years: Int?,

    @field:Json(name="high")
    val high: Int?,

    @field:Json(name="current_weight")
    val current_weight: Int?,

    @field:Json(name="weight")
    val weight: Int?,

    @field:Json(name="body_types")
    val body_types: Int,

    @field:Json(name="typical_days")
    val typical_days: Int?,

    @field:Json(name="habits")
    val habits: Int?,

    @field:Json(name="exercises")
    val exercises: Int?,

    @field:Json(name="energies")
    val energies: Int?,

    @field:Json(name="sleeping")
    val sleeping: Int?,

    @field:Json(name="waters")
    val waters: Int?,
) {
}