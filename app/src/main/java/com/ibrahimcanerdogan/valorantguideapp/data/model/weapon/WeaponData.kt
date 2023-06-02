package com.ibrahimcanerdogan.valorantguideapp.data.model.weapon

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.shop.WeaponShop
import com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.skin.WeaponSkin
import com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.stats.WeaponStat

data class WeaponData(
    @PrimaryKey
    @SerializedName("uuid")
    val uuid: String,
    @SerializedName("displayName")
    val weaponDisplayName: String, // Vandal
    @SerializedName("category")
    val weaponCategory: String, // EEquippableCategory::Rifle
    @SerializedName("defaultSkinUuid")
    val weaponDefaultSkinUuid: String,
    @SerializedName("displayIcon")
    val weaponDisplayIcon: String, // :	https://media.valorant-api.com/weapons/9c82e19d-4575-0200-1a81-3eacf00cf872/displayicon.png
    @SerializedName("killStreamIcon")
    val weaponKillStreamIcon: String,
    @SerializedName("weaponStats")
    val weaponStats: WeaponStat?, // Weapon Damage & Other Stats
    @SerializedName("shopData")
    val weaponShop: WeaponShop?,
    @SerializedName("skins")
    val weaponSkins: List<WeaponSkin>
)