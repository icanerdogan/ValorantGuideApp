package com.ibrahimcanerdogan.valorantguideapp.data.model.other.armor

import com.google.gson.annotations.SerializedName

data class Armor(
    @SerializedName("status")
    val status: Int,
    @SerializedName("data")
    val armors: List<ArmorData>
)