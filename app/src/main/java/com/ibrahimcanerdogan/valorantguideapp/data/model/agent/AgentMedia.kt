package com.ibrahimcanerdogan.valorantguideapp.data.model.agent

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class AgentMedia(
    @SerializedName("id")
    val mediaID: Int,
    @SerializedName("wwise")
    val mediaWwise: String,
    @SerializedName("wave")
    val mediaWave: String
)