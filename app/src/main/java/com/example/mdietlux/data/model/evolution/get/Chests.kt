package com.example.mdietlux.data.model.evolution.get


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Chests(
    @Json(name = "1")
    val x1: X1XX?
)