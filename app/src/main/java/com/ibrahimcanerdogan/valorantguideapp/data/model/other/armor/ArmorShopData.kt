package com.ibrahimcanerdogan.valorantguideapp.data.model.other.armor

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class ArmorShopData(
    @PrimaryKey(autoGenerate = true)
    val armorShopId : Int,
    @SerializedName("cost")
    val armorShopCost: Int,
    @SerializedName("category")
    val armorShopCategory: String,
    @SerializedName("categoryText")
    val armorShopCategoryText: String
)