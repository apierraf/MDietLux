package com.example.mdietlux.data.model.day


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TypicalDays(
    @Json(name = "data")
    val data: List<DataDays>?,
    @Json(name = "links")
    val links: Links?,
    @Json(name = "meta")
    val meta: Meta?
)