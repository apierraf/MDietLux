package com.example.mdietlux.data.model.resume


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Data(
    @Json(name = "body_types")
    val bodyTypes: String?,
    @Json(name = "caloriesForWeightLoss")
    val caloriesForWeightLoss: CaloriesForWeightLoss?,
    @Json(name = "caloriesToMaintainWeight")
    val caloriesToMaintainWeight: CaloriesToMaintainWeight?,
    @Json(name = "corporalChange")
    val corporalChange: Int?,
    @Json(name = "country")
    val country: String?,
    @Json(name = "current_weight")
    val currentWeight: String?,
    @Json(name = "email")
    val email: String?,
    @Json(name = "energies")
    val energies: String?,
    @Json(name = "exercises")
    val exercises: String?,
    @Json(name = "habits")
    val habits: String?,
    @Json(name = "high")
    val high: String?,
    @Json(name = "imc")
    val imc: Double?,
    @Json(name = "imcState")
    val imcState: String?,
    @Json(name = "metabolicAge")
    val metabolicAge: Int?,
    @Json(name = "objectives")
    val objectives: String?,
    @Json(name = "percentageOfEffectiveness")
    val percentageOfEffectiveness: Int?,
    @Json(name = "sex")
    val sex: String?,
    @Json(name = "sleeping")
    val sleeping: String?,
    @Json(name = "typical_days")
    val typicalDays: String?,
    @Json(name = "waterLitres")
    val waterLitres: Double?,
    @Json(name = "waters")
    val waters: String?,
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