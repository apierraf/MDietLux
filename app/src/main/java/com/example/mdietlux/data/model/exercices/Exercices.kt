package com.example.mdietlux.data.model.exercices


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Exercices(
    @Json(name = "data")
    val data: List<DataExercices>?,
    @Json(name = "links")
    val links: Links?,
    @Json(name = "meta")
    val meta: Meta?
)