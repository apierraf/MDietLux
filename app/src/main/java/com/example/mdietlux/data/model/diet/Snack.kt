package com.example.mdietlux.data.model.diet


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Snack(
    @Json(name = "active")
    val active: Int?,
    @Json(name = "calories_value")
    val caloriesValue: Int?,
    @Json(name = "cooking_time_unit")
    val cookingTimeUnit: String?,
    @Json(name = "cooking_time_value")
    val cookingTimeValue: Int?,
    @Json(name = "created_at")
    val createdAt: String?,
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
    @Json(name = "pivot")
    val pivot: PivotXXXX?,
    @Json(name = "preparation_mode")
    val preparationMode: Any?,
    @Json(name = "price")
    val price: Double?,
    @Json(name = "sku")
    val sku: String?,
    @Json(name = "updated_at")
    val updatedAt: String?
)