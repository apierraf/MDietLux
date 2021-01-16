package com.example.mdietlux.data.model.countries


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DataCountries(
    @Json(name = "active")
    val active: Int?,
    @Json(name = "created_at")
    val createdAt: Any?,
    @Json(name = "currency")
    val currency: String?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "image")
    val image: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "order")
    val order: Int?,
    @Json(name = "updated_at")
    val updatedAt: String?
)