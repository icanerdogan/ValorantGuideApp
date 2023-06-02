package com.ibrahimcanerdogan.valorantguideapp.data.model.map

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class MapCallout(
    @PrimaryKey(autoGenerate = true)
    val mapCalloutId : Int,
    @SerializedName("regionName")
    val mapCalloutRegionName: String,
    @SerializedName("superRegionName")
    val mapCalloutSuperRegionName: String,
    @SerializedName("mapLocation")
    val mapCalloutLocation: MapLocation
)