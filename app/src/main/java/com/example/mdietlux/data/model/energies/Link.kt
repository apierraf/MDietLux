package com.example.mdietlux.data.model.energies


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Link(
    @Json(name = "active")
    val active: Boolean?,
    @Json(name = "label")
    val label: Any?,
    @Json(name = "url")
    val url: Any?
)