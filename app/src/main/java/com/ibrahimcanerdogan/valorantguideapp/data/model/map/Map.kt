package com.ibrahimcanerdogan.valorantguideapp.data.model.map

import com.google.gson.annotations.SerializedName

data class Map(
    @SerializedName("status")
    val status: Int,
    @SerializedName("data")
    val maps: List<MapData>
)