package com.example.mdietlux.data.model.evolution.get


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Metric(
    @Json(name = "arm")
    val arm: Int?,
    @Json(name = "calf")
    val calf: Int?,
    @Json(name = "chest")
    val chest: Int?,
    @Json(name = "created_at")
    val createdAt: String?,
    @Json(name = "current_weight")
    val currentWeight: Int?,
    @Json(name = "height")
    val height: Int?,
    @Json(name = "hip")
    val hip: Int?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "neck")
    val neck: Int?,
    @Json(name = "profile_id")
    val profileId: Int?,
    @Json(name = "thigh")
    val thigh: Int?,
    @Json(name = "updated_at")
    val updatedAt: String?,
    @Json(name = "weight")
    val weight: Int?
)