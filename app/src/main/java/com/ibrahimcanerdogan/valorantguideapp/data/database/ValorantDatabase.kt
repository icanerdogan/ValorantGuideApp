package com.ibrahimcanerdogan.valorantguideapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ibrahimcanerdogan.valorantguideapp.data.database.agent.AgentDao
import com.ibrahimcanerdogan.valorantguideapp.data.database.map.MapDao
import com.ibrahimcanerdogan.valorantguideapp.data.database.other.ArmorDao
import com.ibrahimcanerdogan.valorantguideapp.data.database.weapon.WeaponDao
import com.ibrahimcanerdogan.valorantguideapp.data.model.agent.AgentData
import com.ibrahimcanerdogan.valorantguideapp.data.model.map.MapData
import com.ibrahimcanerdogan.valorantguideapp.data.model.other.armor.ArmorData
import com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.WeaponData

@Database(
    entities = [AgentData::class, MapData::class, WeaponData::class, ArmorData::class],
    version = 8,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class ValorantDatabase : RoomDatabase(){

    abstract fun agentDao() : AgentDao

    abstract fun mapDao() : MapDao

    abstract fun weaponDao() : WeaponDao

    abstract fun armorDao() : ArmorDao
}