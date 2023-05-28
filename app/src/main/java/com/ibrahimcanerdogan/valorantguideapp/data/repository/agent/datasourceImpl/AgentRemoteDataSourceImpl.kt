package com.ibrahimcanerdogan.valorantguideapp.data.repository.agent.datasourceImpl

import com.ibrahimcanerdogan.valorantguideapp.data.model.agent.Agent
import com.ibrahimcanerdogan.valorantguideapp.data.remote.APIService
import com.ibrahimcanerdogan.valorantguideapp.data.repository.agent.datasource.AgentRemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class AgentRemoteDataSourceImpl @Inject constructor(
    private val apiService: APIService
): AgentRemoteDataSource {

    override suspend fun getAgentFromRemote(): Response<Agent> {
        return apiService.getAgentRemote()
    }
}