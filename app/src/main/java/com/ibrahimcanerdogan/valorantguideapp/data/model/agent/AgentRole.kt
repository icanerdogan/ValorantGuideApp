package com.ibrahimcanerdogan.valorantguideapp.data.model.agent

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class AgentRole(
    @PrimaryKey
    @SerializedName("uuid")
    val uuid: String,
    @SerializedName("displayName")
    val displayName: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("displayIcon")
    val displayIcon: String,
)