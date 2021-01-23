package com.example.mdietlux.data.model.habits


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Habit(
    @Json(name = "data")
    val data: List<DataHabit>?,
    @Json(name = "links")
    val links: Links?,
    @Json(name = "meta")
    val meta: Meta?
)