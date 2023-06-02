package com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.shop

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class WeaponShop(
    @PrimaryKey(autoGenerate = true)
    val shopId : Int,
    @SerializedName("cost")
    val shopCost: Int, // 2900
    @SerializedName("category")
    val shopCategory: String, // Rifles
    @SerializedName("categoryText")
    val shopCategoryText: String // Assault Rifles
)