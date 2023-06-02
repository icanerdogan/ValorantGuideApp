package com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.skin

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class WeaponSkin(
    @PrimaryKey
    @SerializedName("uuid")
    val uuid: String,
    @SerializedName("themeUuid")
    val skinThemeUuid: String,
    @SerializedName("contentTierUuid")
    val skinContentTierUuid: String?,
    @SerializedName("displayName")
    val skinDisplayName: String, // Immortalized Vandal
    @SerializedName("displayIcon")
    val skinDisplayIcon: String?, // :	https://media.valorant-api.com/weaponskins/d980c0c8-492b-b8df-2d91-af99a7707170/displayicon.png
    @SerializedName("chromas")
    val skinChromas: List<SkinChroma>,
    @SerializedName("levels")
    val skinLevels: List<SkinLevel>
)