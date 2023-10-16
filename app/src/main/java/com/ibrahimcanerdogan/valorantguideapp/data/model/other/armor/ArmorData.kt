package com.ibrahimcanerdogan.valorantguideapp.data.model.other.armor

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(
    tableName = "armor_data"
)
data class ArmorData(
    @PrimaryKey
    @SerializedName("uuid")
    val uuid: String,
    @SerializedName("displayName")
    val armorDisplayName: String,
    @SerializedName("description")
    val armorDescription: String,
    @SerializedName("displayIcon")
    val armorDisplayIcon: String,
    @SerializedName("shopData")
    val armorShopData: ArmorShopData?
)