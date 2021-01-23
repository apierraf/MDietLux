package com.example.mdietlux.data.model.waters


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Waters(
    @Json(name = "data")
    val data: List<DataWaters>?,
    @Json(name = "links")
    val links: Links?,
    @Json(name = "meta")
    val meta: Meta?
)