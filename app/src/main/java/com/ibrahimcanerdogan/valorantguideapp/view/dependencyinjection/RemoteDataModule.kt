package com.ibrahimcanerdogan.valorantguideapp.view.dependencyinjection

import com.ibrahimcanerdogan.valorantguideapp.data.remote.APIService
import com.ibrahimcanerdogan.valorantguideapp.data.repository.agent.datasource.AgentRemoteDataSource
import com.ibrahimcanerdogan.valorantguideapp.data.repository.agent.datasourceImpl.AgentRemoteDataSourceImpl
import com.ibrahimcanerdogan.valorantguideapp.data.repository.map.datasource.MapRemoteDataSource
import com.ibrahimcanerdogan.valorantguideapp.data.repository.map.datasourceImpl.MapRemoteDataSourceImpl
import com.ibrahimcanerdogan.valorantguideapp.data.repository.weapon.datasource.WeaponRemoteDataSource
import com.ibrahimcanerdogan.valorantguideapp.data.repository.weapon.datasourceImpl.WeaponRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideAgentRemoteDataSource(
        apiService: APIService
    ) : AgentRemoteDataSource {
        return AgentRemoteDataSourceImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideMapRemoteDataSource(
        apiService: APIService
    ) : MapRemoteDataSource {
        return MapRemoteDataSourceImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideWeaponRemoteDataSource(
        apiService: APIService
    ) : WeaponRemoteDataSource {
        return WeaponRemoteDataSourceImpl(apiService)
    }
}