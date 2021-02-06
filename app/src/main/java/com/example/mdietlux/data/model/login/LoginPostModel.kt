package com.example.mdietlux.data.model.login

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class LoginPostModel(
        @field:Json(name = "email")
        val email: String,
        @field:Json(name = "password")
        val password: String
) {
}