package com.ibrahimcanerdogan.valorantguideapp.view.dependencyinjection

import com.ibrahimcanerdogan.valorantguideapp.data.database.agent.AgentDao
import com.ibrahimcanerdogan.valorantguideapp.data.database.map.MapDao
import com.ibrahimcanerdogan.valorantguideapp.data.repository.agent.datasource.AgentLocalDataSource
import com.ibrahimcanerdogan.valorantguideapp.data.repository.agent.datasourceImpl.AgentLocalDataSourceImpl
import com.ibrahimcanerdogan.valorantguideapp.data.repository.map.datasource.MapLocalDataSource
import com.ibrahimcanerdogan.valorantguideapp.data.repository.map.datasourceImpl.MapLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

    @Singleton
    @Provides
    fun provideAgentLocalDataSource(
        agentDao: AgentDao
    ): AgentLocalDataSource {
        return AgentLocalDataSourceImpl(agentDao)
    }

    @Singleton
    @Provides
    fun provideMapLocalDataSource(
        mapDao: MapDao
    ): MapLocalDataSource {
        return MapLocalDataSourceImpl(mapDao)
    }
}