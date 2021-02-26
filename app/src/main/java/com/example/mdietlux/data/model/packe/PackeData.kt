package com.example.mdietlux.data.model.packe


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PackeData(
    @Json(name = "data")
    val `data`: List<PackeListData>?,
    @Json(name = "links")
    val links: Links?,
    @Json(name = "meta")
    val meta: Meta?
)