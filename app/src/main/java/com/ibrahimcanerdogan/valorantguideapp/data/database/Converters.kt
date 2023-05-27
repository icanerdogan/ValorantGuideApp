package com.ibrahimcanerdogan.valorantguideapp.data.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ibrahimcanerdogan.valorantguideapp.data.model.agent.Agent
import com.ibrahimcanerdogan.valorantguideapp.data.model.agent.AgentAbility
import com.ibrahimcanerdogan.valorantguideapp.data.model.agent.AgentData
import com.ibrahimcanerdogan.valorantguideapp.data.model.agent.AgentMedia
import com.ibrahimcanerdogan.valorantguideapp.data.model.agent.AgentRole
import com.ibrahimcanerdogan.valorantguideapp.data.model.agent.AgentVoiceLine

class Converters {
    private val gson = Gson()

    // AGENT

    @TypeConverter
    fun fromAgentList(agentList: List<AgentData>): String {
        return gson.toJson(agentList)
    }

    @TypeConverter
    fun toAgentList(agentListString: String): List<AgentData> {
        val listType = object : TypeToken<List<AgentData>>() {}.type
        return gson.fromJson(agentListString, listType)
    }

    @TypeConverter
    fun fromAgent(agent: Agent): String {
        return gson.toJson(agent)
    }

    @TypeConverter
    fun toAgent(agentString: String): Agent {
        return gson.fromJson(agentString, Agent::class.java)
    }

    @TypeConverter
    fun fromAgentAbilityList(abilityList: List<AgentAbility>): String {
        return gson.toJson(abilityList)
    }

    @TypeConverter
    fun toAgentAbilityList(abilityListString: String): List<AgentAbility> {
        val listType = object : TypeToken<List<AgentAbility>>() {}.type
        return gson.fromJson(abilityListString, listType)
    }

    @TypeConverter
    fun fromAgentAbility(ability: AgentAbility): String {
        return gson.toJson(ability)
    }

    @TypeConverter
    fun toAgentAbility(abilityString: String): AgentAbility {
        return gson.fromJson(abilityString, AgentAbility::class.java)
    }

    @TypeConverter
    fun fromAgentMedia(media: AgentMedia): String {
        return gson.toJson(media)
    }

    @TypeConverter
    fun toAgentMedia(mediaString: String): AgentMedia {
        return gson.fromJson(mediaString, AgentMedia::class.java)
    }

    @TypeConverter
    fun fromAgentRole(role: AgentRole): String {
        return gson.toJson(role)
    }

    @TypeConverter
    fun toAgentRole(roleString: String): AgentRole {
        return gson.fromJson(roleString, AgentRole::class.java)
    }

    @TypeConverter
    fun fromAgentVoiceLine(voiceLine: AgentVoiceLine): String {
        return gson.toJson(voiceLine)
    }

    @TypeConverter
    fun toAgentVoiceLine(voiceLineString: String): AgentVoiceLine {
        return gson.fromJson(voiceLineString, AgentVoiceLine::class.java)
    }
}