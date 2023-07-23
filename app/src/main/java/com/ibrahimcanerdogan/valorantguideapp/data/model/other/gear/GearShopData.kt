package com.ibrahimcanerdogan.valorantguideapp.data.model.other.gear

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class GearShopData(
    @PrimaryKey(autoGenerate = true)
    val gearShopID: Int,
    @SerializedName("cost")
    val gearShopCost: Int,
    @SerializedName("category")
    val gearShopCategory: String,
    @SerializedName("categoryText")
    val gearShopCategoryText: String,
    @SerializedName("gridPosition")
    val gearShopGridPosition: Any?,
    @SerializedName("canBeTrashed")
    val gearShopCanBeTrashed: Boolean,
    @SerializedName("image")
    val gearShopImage: Any?,
    @SerializedName("newImage")
    val gearShopNewImage: String,
    @SerializedName("newImage2")
    val gearShopNewImage2: Any?,
)