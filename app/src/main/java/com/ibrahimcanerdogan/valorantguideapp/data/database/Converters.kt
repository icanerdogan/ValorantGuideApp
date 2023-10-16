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
import com.ibrahimcanerdogan.valorantguideapp.data.model.map.MapCallout
import com.ibrahimcanerdogan.valorantguideapp.data.model.map.MapData
import com.ibrahimcanerdogan.valorantguideapp.data.model.map.MapLocation
import com.ibrahimcanerdogan.valorantguideapp.data.model.other.armor.ArmorShopData
import com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.WeaponData
import com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.shop.WeaponShop
import com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.skin.SkinChroma
import com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.skin.SkinLevel
import com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.skin.WeaponSkin
import com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.stats.StatAds
import com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.stats.StatAirBurst
import com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.stats.StatAltShotgun
import com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.stats.StatDamageRange
import com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.stats.WeaponStat

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
    fun fromAgentRole(role: AgentRole?): String? {
        return gson.toJson(role)
    }

    @TypeConverter
    fun toAgentRole(roleString: String?): AgentRole? {
        return gson.fromJson(roleString, AgentRole::class.java)
    }


    @TypeConverter
    fun fromAgentVoiceLine(voiceLine: AgentVoiceLine?): String {
        return gson.toJson(voiceLine)
    }

    @TypeConverter
    fun toAgentVoiceLine(voiceLineString: String): AgentVoiceLine? {
        return gson.fromJson(voiceLineString, AgentVoiceLine::class.java)
    }

    @TypeConverter
    fun fromStringList(stringList: List<String>?): String {
        return gson.toJson(stringList)
    }

    @TypeConverter
    fun toStringList(stringListString: String): List<String>? {
        val listType = object : TypeToken<List<String>?>() {}.type
        return gson.fromJson(stringListString, listType)
    }


    // MAP

    @TypeConverter
    fun fromMapData(mapData: MapData): String {
        return gson.toJson(mapData)
    }

    @TypeConverter
    fun toMapData(json: String): MapData {
        val type = object : TypeToken<MapData>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun fromMapCalloutList(mapCallouts: List<MapCallout>?): String? {
        return gson.toJson(mapCallouts)
    }

    @TypeConverter
    fun toMapCalloutList(json: String?): List<MapCallout>? {
        val type = object : TypeToken<List<MapCallout>>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun fromMapLocation(mapLocation: MapLocation): String {
        return gson.toJson(mapLocation)
    }

    @TypeConverter
    fun toMapLocation(json: String): MapLocation {
        val type = object : TypeToken<MapLocation>() {}.type
        return gson.fromJson(json, type)
    }

    // WEAPON

    @TypeConverter
    fun fromWeaponData(weaponData: WeaponData): String {
        return gson.toJson(weaponData)
    }

    @TypeConverter
    fun toWeaponData(json: String): WeaponData {
        return gson.fromJson(json, WeaponData::class.java)
    }

    @TypeConverter
    fun fromWeaponStat(weaponStat: WeaponStat?): String {
        return gson.toJson(weaponStat)
    }

    @TypeConverter
    fun toWeaponStat(json: String): WeaponStat? {
        return gson.fromJson(json, WeaponStat::class.java)
    }

    @TypeConverter
    fun fromStatAds(statAds: StatAds): String {
        return gson.toJson(statAds)
    }

    @TypeConverter
    fun toStatAds(json: String): StatAds {
        return gson.fromJson(json, StatAds::class.java)
    }

    @TypeConverter
    fun fromStatAltShotgun(statAltShotgun: StatAltShotgun): String {
        return gson.toJson(statAltShotgun)
    }

    @TypeConverter
    fun toStatAltShotgun(json: String): StatAltShotgun {
        return gson.fromJson(json, StatAltShotgun::class.java)
    }

    @TypeConverter
    fun fromStatAirBurst(statAirBurst: StatAirBurst): String {
        return gson.toJson(statAirBurst)
    }

    @TypeConverter
    fun toStatAirBurst(json: String): StatAirBurst {
        return gson.fromJson(json, StatAirBurst::class.java)
    }

    @TypeConverter
    fun fromStatDamageRange(statDamageRange: StatDamageRange): String {
        return gson.toJson(statDamageRange)
    }

    @TypeConverter
    fun toStatDamageRange(json: String): StatDamageRange {
        return gson.fromJson(json, StatDamageRange::class.java)
    }

    @TypeConverter
    fun fromWeaponSkinList(weaponSkins: List<WeaponSkin>?): String? {
        return gson.toJson(weaponSkins)
    }

    @TypeConverter
    fun toWeaponSkinList(json: String?): List<WeaponSkin>? {
        val type = object : TypeToken<List<WeaponSkin>>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun fromSkinChroma(skinChroma: SkinChroma): String {
        return gson.toJson(skinChroma)
    }

    @TypeConverter
    fun toSkinChroma(json: String): SkinChroma {
        return gson.fromJson(json, SkinChroma::class.java)
    }

    @TypeConverter
    fun fromSkinLevel(skinLevel: SkinLevel): String {
        return gson.toJson(skinLevel)
    }

    @TypeConverter
    fun toSkinLevel(json: String): SkinLevel {
        return gson.fromJson(json, SkinLevel::class.java)
    }


    @TypeConverter
    fun fromWeaponShop(weaponShop: WeaponShop?): String {
        return gson.toJson(weaponShop)
    }

    @TypeConverter
    fun toWeaponShop(json: String): WeaponShop? {
        return gson.fromJson(json, WeaponShop::class.java)
    }

    // OTHER

    // Armor

    @TypeConverter
    fun fromArmorShopData(armorShopData: ArmorShopData?): String {
        return gson.toJson(armorShopData)
    }

    @TypeConverter
    fun toArmorShopData(data: String): ArmorShopData? {
        val listType = object : TypeToken<ArmorShopData>() {}.type
        return gson.fromJson(data, listType)
    }

}