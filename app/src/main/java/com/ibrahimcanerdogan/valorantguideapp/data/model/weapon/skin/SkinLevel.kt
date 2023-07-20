package com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.skin

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class SkinLevel(
    @PrimaryKey
    @SerializedName("uuid")
    val uuid: String,
    @SerializedName("displayName")
    val levelDisplayName: String,
    @SerializedName("levelItem")
    val levelItem: String?,
    @SerializedName("displayIcon")
    val levelDisplayIcon: String?,
    @SerializedName("streamedVideo")
    val levelStreamedVideo: String?,
)