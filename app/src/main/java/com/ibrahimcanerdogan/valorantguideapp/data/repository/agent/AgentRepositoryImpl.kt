package com.ibrahimcanerdogan.valorantguideapp.data.repository.agent

import android.util.Log
import com.ibrahimcanerdogan.valorantguideapp.data.model.agent.Agent
import com.ibrahimcanerdogan.valorantguideapp.data.model.agent.AgentData
import com.ibrahimcanerdogan.valorantguideapp.data.repository.agent.datasource.AgentLocalDataSource
import com.ibrahimcanerdogan.valorantguideapp.data.repository.agent.datasource.AgentRemoteDataSource
import com.ibrahimcanerdogan.valorantguideapp.domain.repository.agent.AgentRepository
import com.ibrahimcanerdogan.valorantguideapp.util.Resource
import retrofit2.Response
import javax.inject.Inject

class AgentRepositoryImpl @Inject constructor(
    private val agentRemoteDataSource: AgentRemoteDataSource,
    private val agentLocalDataSource: AgentLocalDataSource
) : AgentRepository {

    override suspend fun getAllAgentsFromRepository(): Resource<List<AgentData>> {
        return getAgentDataFromDatabase()
    }

    private suspend fun getAgentDataFromDatabase() : Resource<List<AgentData>> {
        lateinit var agentData: Resource<List<AgentData>>
        try {
            agentData = agentLocalDataSource.getAgentDataFromLocal()
        } catch (e : Exception) {
            Log.e(TAG, e.message.toString())
        }

        if (agentData.data!!.isNotEmpty()) {
            return agentData
        } else {
            agentData = responseToResource(agentRemoteDataSource.getAgentFromRemote())
            // Remove duplicate Sova agent for Locale.
            agentLocalDataSource.saveAgentDataToLocal(agentData.data!!.filter { agent ->
                agent.agentIsPlayableCharacter
            })
        }

        return agentData
    }

    private fun responseToResource(response: Response<Agent>):Resource<List<AgentData>>{
        if(response.isSuccessful){
            response.body()?.let {result->
                // Remove duplicate Sova agent for Remote.
                return Resource.Success(result.agents.filter { agent ->
                    agent.agentIsPlayableCharacter
                })
            }
        }
        return Resource.Error(response.message())
    }

    companion object {
        private val TAG = AgentRepositoryImpl::class.java.toString()
    }

}