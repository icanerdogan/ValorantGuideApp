package com.ibrahimcanerdogan.valorantguideapp.view.dependencyinjection

import android.app.Application
import com.ibrahimcanerdogan.valorantguideapp.domain.usecase.agent.GetAgentUseCase
import com.ibrahimcanerdogan.valorantguideapp.domain.usecase.map.GetMapUseCase
import com.ibrahimcanerdogan.valorantguideapp.view.viewmodel.agent.AgentViewModelFactory
import com.ibrahimcanerdogan.valorantguideapp.view.viewmodel.map.MapViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Singleton
    @Provides
    fun provideAgentViewModelFactory(
        application: Application,
        getAgentUseCase: GetAgentUseCase
    ) : AgentViewModelFactory {
        return AgentViewModelFactory(
            application,
            getAgentUseCase
        )
    }

    @Singleton
    @Provides
    fun provideMapViewModelFactory(
        application: Application,
        getMapUseCase: GetMapUseCase
    ) : MapViewModelFactory {
        return MapViewModelFactory(
            application,
            getMapUseCase
        )
    }
}