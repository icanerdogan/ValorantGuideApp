package com.ibrahimcanerdogan.valorantguideapp.data.model.agent

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class AgentVoiceLine(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    @SerializedName("minDuration")
    val minDuration: Double,
    @SerializedName("maxDuration")
    val maxDuration: Double,
    @SerializedName("mediaList")
    val mediaList: List<AgentMedia>
)