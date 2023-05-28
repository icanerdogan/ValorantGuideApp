package com.ibrahimcanerdogan.valorantguideapp.domain.repository.agent

import com.ibrahimcanerdogan.valorantguideapp.data.model.agent.Agent
import com.ibrahimcanerdogan.valorantguideapp.data.model.agent.AgentData
import com.ibrahimcanerdogan.valorantguideapp.util.Resource

interface AgentRepository {

    suspend fun getAllAgentsFromRepository() : Resource<List<AgentData>>

}