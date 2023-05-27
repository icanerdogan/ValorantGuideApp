package com.ibrahimcanerdogan.valorantguideapp.domain.usecase.agent

import com.ibrahimcanerdogan.valorantguideapp.data.model.agent.Agent
import com.ibrahimcanerdogan.valorantguideapp.domain.repository.agent.AgentRepository
import com.ibrahimcanerdogan.valorantguideapp.util.Resource

class GetAgentUseCase(
    private val agentRepository: AgentRepository
) {

    suspend fun execute() : Resource<Agent> {
        return agentRepository.getAllAgents()
    }
}