package com.ibrahimcanerdogan.valorantguideapp.data.database.agent

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ibrahimcanerdogan.valorantguideapp.data.model.agent.AgentData
import kotlinx.coroutines.flow.Flow

@Dao
interface AgentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(agent: AgentData)

    @Query("SELECT * FROM agent_data")
    fun getAllArticles(): Flow<List<AgentData>>
}