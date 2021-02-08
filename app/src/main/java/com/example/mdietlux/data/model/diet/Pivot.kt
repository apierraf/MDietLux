package com.example.mdietlux.data.model.diet


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Pivot(
    @Json(name = "diet_schedule_id")
    val dietScheduleId: Int?,
    @Json(name = "food_dish_id")
    val foodDishId: Int?,
    @Json(name = "order")
    val order: Int?
)