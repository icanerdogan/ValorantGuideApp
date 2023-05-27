package com.ibrahimcanerdogan.valorantguideapp.data.model.agent

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName

@Entity(
    tableName = "agent_data"
)
data class AgentData(
    @PrimaryKey
    @SerializedName("uuid")
    val uuid: String,
    @SerializedName("displayName")
    val agentDisplayName: String,
    @SerializedName("description")
    val agentDescription: String,
    @SerializedName("displayIcon")
    val agentDisplayIcon: String,
    @SerializedName("displayIconSmall")
    val agentDisplayIconSmall: String,
    @SerializedName("bustPortrait")
    val agentBustPortrait: String?,
    @SerializedName("fullPortrait")
    val agentFullPortrait: String?,
    @SerializedName("fullPortraitV2")
    val agentFullPortraitV2: String?,
    @SerializedName("killfeedPortrait")
    val agentKillFeedPortrait: String,
    @SerializedName("background")
    val agentBackground: String?,
    @SerializedName("isPlayableCharacter")
    val agentIsPlayableCharacter: Boolean,
    @SerializedName("role")
    val agentRole: AgentRole?,
    @SerializedName("abilities")
    val agentAbilities: List<AgentAbility>,
    @SerializedName("voiceLine")
    val agentVoiceLine: AgentVoiceLine
)