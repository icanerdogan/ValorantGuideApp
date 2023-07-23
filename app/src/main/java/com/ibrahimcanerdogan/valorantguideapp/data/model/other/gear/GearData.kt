package com.ibrahimcanerdogan.valorantguideapp.data.model.other.gear

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(
    tableName = "gear_data"
)
data class GearData(
    @PrimaryKey
    @SerializedName("uuid")
    val uuid: String,
    @SerializedName("displayName")
    val gearDisplayName: String,
    @SerializedName("description")
    val gearDescription: String,
    @SerializedName("displayIcon")
    val gearDisplayIcon: String,
    @SerializedName("shopData")
    val gearShopData: GearShopData
)