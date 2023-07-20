package com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.skin

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class SkinChroma(
    @PrimaryKey
    @SerializedName("uuid")
    val uuid: String,
    @SerializedName("displayName")
    val chromaDisplayName: String, // Araxys Bulldog Level 4\n(Variant 1 Purple)
    @SerializedName("displayIcon")
    val chromaDisplayIcon: String?, // null or same full render
    @SerializedName("fullRender")
    val chromaFullRender: String, // https://media.valorant-api.com/weaponskinchromas/49451aa7-4a30-3d0e-2cf9-a19afc966041/fullrender.png
    @SerializedName("swatch")
    val chromaSwatch: String?,
    @SerializedName("streamedVideo")
    val chromaStreamedVideo: String?
)