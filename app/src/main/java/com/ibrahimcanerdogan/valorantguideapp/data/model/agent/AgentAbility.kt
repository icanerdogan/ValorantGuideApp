package com.ibrahimcanerdogan.valorantguideapp.data.model.agent

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class AgentAbility(
    @PrimaryKey(autoGenerate = true)
    val abilityID: String,
    @SerializedName("displayName")
    val abilityDisplayName: String,
    @SerializedName("description")
    val abilityDescription: String,
    @SerializedName("displayIcon")
    val abilityDisplayIcon: String?
)