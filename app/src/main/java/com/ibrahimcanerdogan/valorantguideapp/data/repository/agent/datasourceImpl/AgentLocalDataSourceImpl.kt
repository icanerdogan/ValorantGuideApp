package com.ibrahimcanerdogan.valorantguideapp.data.repository.agent.datasourceImpl

import com.ibrahimcanerdogan.valorantguideapp.data.database.agent.AgentDao
import com.ibrahimcanerdogan.valorantguideapp.data.model.agent.AgentData
import com.ibrahimcanerdogan.valorantguideapp.data.repository.agent.datasource.AgentLocalDataSource
import com.ibrahimcanerdogan.valorantguideapp.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AgentLocalDataSourceImpl @Inject constructor(
    private val agentDao: AgentDao
) : AgentLocalDataSource {

    override suspend fun saveAgentDataToLocal(agentList: List<AgentData>) {
        return agentDao.saveAgentDatabase(agentList)
    }

    override suspend fun getAgentDataFromLocal(): Resource<List<AgentData>> {
        return Resource.Success(agentDao.getAgentListDatabase())
    }
}