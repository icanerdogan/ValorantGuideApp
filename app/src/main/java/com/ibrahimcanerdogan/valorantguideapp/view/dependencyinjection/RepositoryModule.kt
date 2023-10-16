package com.ibrahimcanerdogan.valorantguideapp.view.dependencyinjection

import com.ibrahimcanerdogan.valorantguideapp.data.repository.agent.AgentRepositoryImpl
import com.ibrahimcanerdogan.valorantguideapp.data.repository.agent.datasource.AgentLocalDataSource
import com.ibrahimcanerdogan.valorantguideapp.data.repository.agent.datasource.AgentRemoteDataSource
import com.ibrahimcanerdogan.valorantguideapp.data.repository.map.MapRepositoryImpl
import com.ibrahimcanerdogan.valorantguideapp.data.repository.map.datasource.MapLocalDataSource
import com.ibrahimcanerdogan.valorantguideapp.data.repository.map.datasource.MapRemoteDataSource
import com.ibrahimcanerdogan.valorantguideapp.data.repository.other.armor.ArmorRepositoryImpl
import com.ibrahimcanerdogan.valorantguideapp.data.repository.other.armor.datasource.ArmorLocalDataSource
import com.ibrahimcanerdogan.valorantguideapp.data.repository.other.armor.datasource.ArmorRemoteDataSource
import com.ibrahimcanerdogan.valorantguideapp.data.repository.weapon.WeaponRepositoryImpl
import com.ibrahimcanerdogan.valorantguideapp.data.repository.weapon.datasource.WeaponLocalDataSource
import com.ibrahimcanerdogan.valorantguideapp.data.repository.weapon.datasource.WeaponRemoteDataSource
import com.ibrahimcanerdogan.valorantguideapp.domain.repository.agent.AgentRepository
import com.ibrahimcanerdogan.valorantguideapp.domain.repository.map.MapRepository
import com.ibrahimcanerdogan.valorantguideapp.domain.repository.other.armor.ArmorRepository
import com.ibrahimcanerdogan.valorantguideapp.domain.repository.weapon.WeaponRepository
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

    @Singleton
    @Provides
    fun provideMapRepository(
        mapRemoteDataSource: MapRemoteDataSource,
        mapLocalDataSource: MapLocalDataSource
    ) : MapRepository {
        return MapRepositoryImpl(mapRemoteDataSource, mapLocalDataSource)
    }

    @Singleton
    @Provides
    fun provideWeaponRepository(
        weaponRemoteDataSource: WeaponRemoteDataSource,
        weaponLocalDataSource: WeaponLocalDataSource
    ) : WeaponRepository {
        return WeaponRepositoryImpl(weaponRemoteDataSource, weaponLocalDataSource)
    }

    @Singleton
    @Provides
    fun provideArmorRepository(
        armorRemoteDataSource: ArmorRemoteDataSource,
        armorLocalDataSource: ArmorLocalDataSource
    ) : ArmorRepository {
        return ArmorRepositoryImpl(armorRemoteDataSource, armorLocalDataSource)
    }
}