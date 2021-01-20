package com.example.mdietlux.data.model.objetives


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ObjetivesModel(
    @Json(name = "data")
    val data: List<DataObjetive>?,
    @Json(name = "links")
    val links: Links?,
    @Json(name = "meta")
    val meta: Meta?
)