package com.example.mdietlux.data.model.body


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DataBody(
    @Json(name = "active")
    val active: Int?,
    @Json(name = "created_at")
    val createdAt: String?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "image")
    val image: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "sex")
    val sex: String?,
    @Json(name = "updated_at")
    val updatedAt: String?
)