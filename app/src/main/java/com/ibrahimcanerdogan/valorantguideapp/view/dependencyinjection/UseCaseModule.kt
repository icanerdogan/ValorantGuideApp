package com.ibrahimcanerdogan.valorantguideapp.view.dependencyinjection

import com.ibrahimcanerdogan.valorantguideapp.domain.repository.agent.AgentRepository
import com.ibrahimcanerdogan.valorantguideapp.domain.repository.map.MapRepository
import com.ibrahimcanerdogan.valorantguideapp.domain.usecase.agent.GetAgentUseCase
import com.ibrahimcanerdogan.valorantguideapp.domain.usecase.map.GetMapUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetAgentUseCase(
        agentRepository: AgentRepository
    ) : GetAgentUseCase {
        return GetAgentUseCase(agentRepository)
    }

    @Singleton
    @Provides
    fun provideGetMapUseCase(
        mapRepository: MapRepository
    ) : GetMapUseCase {
        return GetMapUseCase(mapRepository)
    }
}