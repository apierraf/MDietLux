package com.example.mdietlux.data.model.exercices


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DataExercices(
    @Json(name = "created_at")
    val createdAt: String?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "updated_at")
    val updatedAt: String?,
    @Json(name = "weight")
    val weight: Int?
)