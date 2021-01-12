package com.example.mdietlux.data.model.resume


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Resume(
        @Json(name = "body_types")
    val bodyTypes: List<String>?,
        @Json(name = "caloriesForWeightLoss")
    val caloriesForWeightLoss: CaloriesForWeightLoss?,
        @Json(name = "caloriesToMaintain")
    val caloriesToMaintain: Double?,
        @Json(name = "caloriesToMaintainWeight")
    val caloriesToMaintainWeight: CaloriesToMaintainWeight?,
        @Json(name = "corporalChange")
    val corporalChange: Int?,
        @Json(name = "country")
    val country: List<String>?,
        @Json(name = "current_weight")
    val currentWeight: String?,
        @Json(name = "energies")
    val energies: List<String>?,
        @Json(name = "excercises")
    val excercises: List<String>?,
        @Json(name = "habits")
    val habits: List<String>?,
        @Json(name = "high")
    val high: String?,
        @Json(name = "imc")
    val imc: Double?,
        @Json(name = "imcState")
    val imcState: String?,
        @Json(name = "metabolicAge")
    val metabolicAge: Int?,
        @Json(name = "objectives")
    val objectives: List<String>?,
        @Json(name = "percentageOfEffectiveness")
    val percentageOfEffectiveness: Int?,
        @Json(name = "restriction_types")
    val restrictionTypes: List<String>?,
        @Json(name = "session_id")
    val sessionId: String?,
        @Json(name = "sex")
    val sex: String?,
        @Json(name = "sleeping")
    val sleeping: List<String>?,
        @Json(name = "_token")
    val token: String?,
        @Json(name = "typical_days")
    val typicalDays: List<String>?,
        @Json(name = "waterLitres")
    val waterLitres: Double?,
        @Json(name = "waters")
    val waters: List<String>?,
        @Json(name = "weight")
    val weight: String?,
        @Json(name = "weightLossFirstMonth")
    val weightLossFirstMonth: WeightLossFirstMonth?,
        @Json(name = "weightLossFirstWeek")
    val weightLossFirstWeek: Double?,
        @Json(name = "weightLossSecondMonth")
    val weightLossSecondMonth: WeightLossSecondMonth?,
        @Json(name = "weightLossStartMonth")
    val weightLossStartMonth: WeightLossStartMonth?,
        @Json(name = "years")
    val years: String?
)