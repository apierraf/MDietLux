package com.example.mdietlux.data.model.body


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BodyTypes(
    @Json(name = "data")
    val data: List<DataBody>?,
    @Json(name = "links")
    val links: Links?,
    @Json(name = "meta")
    val meta: Meta?
)