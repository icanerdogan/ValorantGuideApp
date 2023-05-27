package com.ibrahimcanerdogan.valorantguideapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ibrahimcanerdogan.valorantguideapp.data.database.agent.AgentDao
import com.ibrahimcanerdogan.valorantguideapp.data.model.agent.Agent

@Database(
    entities = [Agent::class],
    version = 1,
    exportSchema = false
)
abstract class ValorantDatabase : RoomDatabase(){
    abstract fun agentDao() : AgentDao
}