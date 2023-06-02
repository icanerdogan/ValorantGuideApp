package com.ibrahimcanerdogan.valorantguideapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ibrahimcanerdogan.valorantguideapp.data.database.agent.AgentDao
import com.ibrahimcanerdogan.valorantguideapp.data.database.map.MapDao
import com.ibrahimcanerdogan.valorantguideapp.data.model.agent.AgentData
import com.ibrahimcanerdogan.valorantguideapp.data.model.map.MapData

@Database(
    entities = [AgentData::class, MapData::class],
    version = 3,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class ValorantDatabase : RoomDatabase(){
    abstract fun agentDao() : AgentDao

    abstract fun mapDao() : MapDao
}