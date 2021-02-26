package com.example.mdietlux.data.model.packe


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PackeListData(
    @Json(name = "created_at")
    val createdAt: String?,
    @Json(name = "currency")
    val currency: String?,
    @Json(name = "discount_promotion")
    val discountPromotion: String?,
    @Json(name = "facturation_months")
    val facturationMonths: Int?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "membership_months")
    val membershipMonths: Int?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "price")
    val price: Int?,
    @Json(name = "state")
    val state: String?,
    @Json(name = "updated_at")
    val updatedAt: String?,
    @Json(name = "weeks")
    val weeks: Int?
)