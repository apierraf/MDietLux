package com.example.mdietlux.data.model.countries


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Countries(
    @Json(name = "data")
    val data: List<DataCountries>?,
    @Json(name = "links")
    val links: Links?,
    @Json(name = "meta")
    val meta: Meta?
)