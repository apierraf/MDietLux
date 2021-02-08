package com.example.mdietlux.data.model.diet


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PivotXXXXX(
    @Json(name = "diet_id")
    val dietId: Int?,
    @Json(name = "option_id")
    val optionId: Int?,
    @Json(name = "state")
    val state: String?,
    @Json(name = "user_id")
    val userId: Int?
)