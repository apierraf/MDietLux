package com.example.mdietlux.data.model.diet


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Diets(
    @Json(name = "active")
    val active: Int?,
    @Json(name = "created_at")
    val createdAt: String?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "diet_schedules")
    val dietSchedules: List<DietSchedule>?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "pivot")
    val pivot: PivotXXXXX?,
    @Json(name = "updated_at")
    val updatedAt: String?
)