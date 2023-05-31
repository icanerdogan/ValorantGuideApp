package com.ibrahimcanerdogan.valorantguideapp.view.dependencyinjection

import com.ibrahimcanerdogan.valorantguideapp.data.repository.agent.AgentRepositoryImpl
import com.ibrahimcanerdogan.valorantguideapp.data.repository.agent.datasource.AgentLocalDataSource
import com.ibrahimcanerdogan.valorantguideapp.data.repository.agent.datasource.AgentRemoteDataSource
import com.ibrahimcanerdogan.valorantguideapp.domain.repository.agent.AgentRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideAgentRepository(
        agentRemoteDataSource: AgentRemoteDataSource,
        agentLocalDataSource: AgentLocalDataSource
    ) : AgentRepository {
        return AgentRepositoryImpl(agentRemoteDataSource, agentLocalDataSource)
    }
}