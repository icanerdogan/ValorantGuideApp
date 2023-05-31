package com.ibrahimcanerdogan.valorantguideapp.data.repository.agent.datasource

import com.ibrahimcanerdogan.valorantguideapp.data.model.agent.AgentData
import com.ibrahimcanerdogan.valorantguideapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface AgentLocalDataSource {

    suspend fun saveAgentDataToLocal(agentList: List<AgentData>)

    suspend fun getAgentDataFromLocal() : Resource<List<AgentData>>

}