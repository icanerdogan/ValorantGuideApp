package com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.stats

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class WeaponStat(
    @PrimaryKey(autoGenerate = true)
    val statId: Int,
    @SerializedName("fireRate")
    val statFireRate: Double,
    @SerializedName("magazineSize")
    val statMagazineSize: Int,
    @SerializedName("runSpeedMultiplier")
    val statRunSpeedMultiplier: Double,
    @SerializedName("equipTimeSeconds")
    val statEquipTimeSeconds: Double,
    @SerializedName("reloadTimeSeconds")
    val statReloadTimeSeconds: Double,
    @SerializedName("firstBulletAccuracy")
    val statFirstBulletAccuracy: Double,
    @SerializedName("shotgunPelletCount")
    val statShotgunPelletCount: Int,
    @SerializedName("wallPenetration")
    val statWallPenetration: String,
    @SerializedName("feature")
    val statFeature: String?,
    @SerializedName("fireMode")
    val statFireMode: String?,
    @SerializedName("altFireType")
    val statAltFireType: String?,
    @SerializedName("adsStats")
    val statAds: StatAds?,
    @SerializedName("altShotgunStats")
    val statAltShotgun: StatAltShotgun?,
    @SerializedName("airBurstStats")
    val statAirBurst: StatAirBurst?,
    @SerializedName("damageRanges")
    val statDamageRanges: List<StatDamageRange>
)