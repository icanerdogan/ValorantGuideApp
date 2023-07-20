package com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.stats

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class StatAirBurst(
    @PrimaryKey(autoGenerate = true)
    val burstId: Int,
    @SerializedName("shotgunPelletCount")
    val burstShotgunPelletCount: Int,
    @SerializedName("burstDistance")
    val burstDistance: Double
)