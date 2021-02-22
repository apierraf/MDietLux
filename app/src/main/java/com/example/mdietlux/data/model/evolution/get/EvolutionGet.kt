package com.example.mdietlux.data.model.evolution.get


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EvolutionGet(
    @Json(name = "arms")
    val arms: Arms?,
    @Json(name = "body_type_id")
    val bodyTypeId: Int?,
    @Json(name = "calfs")
    val calfs: Calfs?,
    @Json(name = "caloriesForWeightLoss")
    val caloriesForWeightLoss: CaloriesForWeightLoss?,
    @Json(name = "caloriesToMaintainWeight")
    val caloriesToMaintainWeight: CaloriesToMaintainWeight?,
    @Json(name = "chests")
    val chests: Chests?,
    @Json(name = "country")
    val country: String?,
    @Json(name = "created_at")
    val createdAt: String?,
    @Json(name = "energy_id")
    val energyId: Int?,
    @Json(name = "exercise_id")
    val exerciseId: String?,
    @Json(name = "hips")
    val hips: Hips?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "imc")
    val imc: Double?,
    @Json(name = "imcState")
    val imcState: String?,
    @Json(name = "metric")
    val metric: Metric?,
    @Json(name = "necks")
    val necks: Necks?,
    @Json(name = "objective_id")
    val objectiveId: Int?,
    @Json(name = "sex")
    val sex: String?,
    @Json(name = "sleeping_id")
    val sleepingId: Int?,
    @Json(name = "thighs")
    val thighs: Thighs?,
    @Json(name = "typical_day_id")
    val typicalDayId: Int?,
    @Json(name = "updated_at")
    val updatedAt: String?,
    @Json(name = "user_id")
    val userId: Int?,
    @Json(name = "water_id")
    val waterId: Int?,
    @Json(name = "weights")
    val weights: Weights?,
    @Json(name = "years")
    val years: Int?
)