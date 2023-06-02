package com.ibrahimcanerdogan.valorantguideapp.data.model.map

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class MapLocation(
    @PrimaryKey(autoGenerate = true)
    val mapLocationId : Int,
    @SerializedName("x")
    val mapLocationX: Double,
    @SerializedName("y")
    val mapLocationY: Double
)