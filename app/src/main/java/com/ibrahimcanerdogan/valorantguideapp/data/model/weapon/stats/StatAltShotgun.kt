package com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.stats

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class StatAltShotgun(
    @PrimaryKey(autoGenerate = true)
    val shotgunId: Int,
    @SerializedName("shotgunPelletCount")
    val shotgunPelletCount: Int,
    @SerializedName("burstRate")
    val shotgunBurstRate: Double
)