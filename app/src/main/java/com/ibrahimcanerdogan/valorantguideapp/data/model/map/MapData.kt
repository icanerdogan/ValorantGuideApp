package com.ibrahimcanerdogan.valorantguideapp.data.model.map

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(
    tableName = "map_data"
)
data class MapData(
    @PrimaryKey
    @SerializedName("uuid")
    val uuid: String,
    @SerializedName("displayName")
    val mapDisplayName: String,
    @SerializedName("coordinates")
    val mapCoordinates: String?,
    @SerializedName("displayIcon")
    val mapDisplayIcon: String?,
    @SerializedName("listViewIcon")
    val mapListViewIcon: String,
    @SerializedName("splash")
    val mapSplashIcon: String,
    @SerializedName("callouts")
    val mapCallouts: List<MapCallout>?
)