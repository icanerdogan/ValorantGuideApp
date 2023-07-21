package com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.stats

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class StatDamageRange(
    @PrimaryKey(autoGenerate = true)
    val damageRangeId: Int,
    @SerializedName("rangeStartMeters")
    val damageStartMeters: Int,
    @SerializedName("rangeEndMeters")
    val damageEndMeters: Int,
    @SerializedName("headDamage")
    val damageHead: Double,
    @SerializedName("bodyDamage")
    val damageBody: Int,
    @SerializedName("legDamage")
    val damageLeg: Double
)