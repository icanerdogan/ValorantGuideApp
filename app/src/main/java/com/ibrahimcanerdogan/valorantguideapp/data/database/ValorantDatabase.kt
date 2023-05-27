package com.ibrahimcanerdogan.valorantguideapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ibrahimcanerdogan.valorantguideapp.data.database.agent.AgentDao
import com.ibrahimcanerdogan.valorantguideapp.data.model.agent.AgentData

@Database(
    entities = [AgentData::class],
    version = 2,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class ValorantDatabase : RoomDatabase(){
    abstract fun agentDao() : AgentDao
}