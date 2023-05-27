package com.ibrahimcanerdogan.valorantguideapp.domain.repository.agent

import com.ibrahimcanerdogan.valorantguideapp.data.model.agent.Agent
import com.ibrahimcanerdogan.valorantguideapp.util.Resource

interface AgentRepository {

    suspend fun getAllAgents() : Resource<Agent>
}