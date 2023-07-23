package com.ibrahimcanerdogan.valorantguideapp.data.model.other.gear

import com.google.gson.annotations.SerializedName

data class Gear(
    @SerializedName("status")
    val status: Int,
    @SerializedName("data")
    val gears: List<GearData>
)