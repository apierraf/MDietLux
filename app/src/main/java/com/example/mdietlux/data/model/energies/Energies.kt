package com.example.mdietlux.data.model.energies


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Energies(
    @Json(name = "data")
    val data: List<DataEnergies>?,
    @Json(name = "links")
    val links: Links?,
    @Json(name = "meta")
    val meta: Meta?
)