package com.example.mdietlux.data.model.sleeping


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Sleeping(
    @Json(name = "data")
    val data: List<DataSleeping>?,
    @Json(name = "links")
    val links: Links?,
    @Json(name = "meta")
    val meta: Meta?
)