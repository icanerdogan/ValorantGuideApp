package com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.stats

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class StatAds(
    @PrimaryKey(autoGenerate = true)
    val adsId: Int,
    @SerializedName("zoomMultiplier")
    val adsZoomMultiplier: Double,
    @SerializedName("fireRate")
    val adsFireRate: Double,
    @SerializedName("runSpeedMultiplier")
    val adsRunSpeedMultiplier: Double,
    @SerializedName("burstCount")
    val adsBurstCount: Int,
    @SerializedName("firstBulletAccuracy")
    val adsFirstBulletAccuracy: Double
)