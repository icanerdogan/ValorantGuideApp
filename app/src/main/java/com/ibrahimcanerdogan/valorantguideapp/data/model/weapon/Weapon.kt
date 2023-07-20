package com.ibrahimcanerdogan.valorantguideapp.data.model.weapon

import com.google.gson.annotations.SerializedName

data class Weapon(
    @SerializedName("status")
    val status: Int,
    @SerializedName("data")
    val weapons: List<WeaponData>
)