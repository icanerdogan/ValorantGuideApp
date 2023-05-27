package com.ibrahimcanerdogan.valorantguideapp.data.repository.agent

import com.ibrahimcanerdogan.valorantguideapp.data.model.agent.Agent
import com.ibrahimcanerdogan.valorantguideapp.data.repository.agent.datasource.AgentRemoteDataSource
import com.ibrahimcanerdogan.valorantguideapp.domain.repository.agent.AgentRepository
import com.ibrahimcanerdogan.valorantguideapp.util.Resource
import retrofit2.Response

class AgentRepositoryImpl(
    private val agentRemoteDataSource: AgentRemoteDataSource
) : AgentRepository {

    override suspend fun getAllAgents(): Resource<Agent> {
        return responseToResource(agentRemoteDataSource.getAllAgents())
    }

    private fun responseToResource(response: Response<Agent>):Resource<Agent>{
        if(response.isSuccessful){
            response.body()?.let {result->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }
}