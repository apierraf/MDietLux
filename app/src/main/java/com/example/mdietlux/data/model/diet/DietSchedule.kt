package com.example.mdietlux.data.model.diet


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DietSchedule(
    @Json(name = "breakfast")
    val breakfast: List<Breakfast>?,
    @Json(name = "created_at")
    val createdAt: String?,
    @Json(name = "day")
    val day: Int?,
    @Json(name = "diet_id")
    val dietId: Int?,
    @Json(name = "dinner")
    val dinner: List<Dinner>?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "launch")
    val launch: List<Launch>?,
    @Json(name = "morning_snack")
    val morningSnack: List<MorningSnack>?,
    @Json(name = "snack")
    val snack: List<Snack>?,
    @Json(name = "updated_at")
    val updatedAt: String?
)