package com.ibrahimcanerdogan.valorantguideapp.data.repository.agent.datasource

import com.ibrahimcanerdogan.valorantguideapp.data.model.agent.Agent
import retrofit2.Response

interface AgentRemoteDataSource {

    suspend fun getAllAgents() : Response<Agent>
}