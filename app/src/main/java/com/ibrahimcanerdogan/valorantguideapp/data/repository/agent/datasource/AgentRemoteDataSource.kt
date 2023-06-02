package com.ibrahimcanerdogan.valorantguideapp.data.repository.agent.datasource

import com.ibrahimcanerdogan.valorantguideapp.data.model.agent.Agent
import com.ibrahimcanerdogan.valorantguideapp.data.model.agent.AgentData
import com.ibrahimcanerdogan.valorantguideapp.util.Resource
import retrofit2.Response

interface AgentRemoteDataSource {

    suspend fun getAgentFromRemote() : Response<Agent>
}