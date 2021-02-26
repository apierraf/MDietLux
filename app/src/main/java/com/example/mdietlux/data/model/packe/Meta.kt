package com.example.mdietlux.data.model.packe


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Meta(
    @Json(name = "current_page")
    val currentPage: Int?,
    @Json(name = "from")
    val from: Int?,
    @Json(name = "last_page")
    val lastPage: Int?,
    @Json(name = "links")
    val links: List<Link>?,
    @Json(name = "path")
    val path: String?,
    @Json(name = "per_page")
    val perPage: Int?,
    @Json(name = "to")
    val to: Int?,
    @Json(name = "total")
    val total: Int?
)