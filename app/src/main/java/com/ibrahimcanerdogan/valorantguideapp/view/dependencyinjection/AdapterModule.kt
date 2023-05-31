package com.ibrahimcanerdogan.valorantguideapp.view.dependencyinjection

import com.ibrahimcanerdogan.valorantguideapp.view.adapter.agent.AgentAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {

    @Singleton
    @Provides
    fun provideAgentAdapter() : AgentAdapter {
        return AgentAdapter()
    }
}