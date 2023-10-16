package com.ibrahimcanerdogan.valorantguideapp.view.dependencyinjection

import com.ibrahimcanerdogan.valorantguideapp.data.database.agent.AgentDao
import com.ibrahimcanerdogan.valorantguideapp.data.database.map.MapDao
import com.ibrahimcanerdogan.valorantguideapp.data.database.other.ArmorDao
import com.ibrahimcanerdogan.valorantguideapp.data.database.weapon.WeaponDao
import com.ibrahimcanerdogan.valorantguideapp.data.repository.agent.datasource.AgentLocalDataSource
import com.ibrahimcanerdogan.valorantguideapp.data.repository.agent.datasourceImpl.AgentLocalDataSourceImpl
import com.ibrahimcanerdogan.valorantguideapp.data.repository.map.datasource.MapLocalDataSource
import com.ibrahimcanerdogan.valorantguideapp.data.repository.map.datasourceImpl.MapLocalDataSourceImpl
import com.ibrahimcanerdogan.valorantguideapp.data.repository.other.armor.datasource.ArmorLocalDataSource
import com.ibrahimcanerdogan.valorantguideapp.data.repository.other.armor.datasourceImpl.ArmorLocalDataSourceImpl
import com.ibrahimcanerdogan.valorantguideapp.data.repository.weapon.datasource.WeaponLocalDataSource
import com.ibrahimcanerdogan.valorantguideapp.data.repository.weapon.datasourceImpl.WeaponLocalDataSourceImpl
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

    @Singleton
    @Provides
    fun provideWeaponLocalDataSource(
        weaponDao: WeaponDao
    ): WeaponLocalDataSource {
        return WeaponLocalDataSourceImpl(weaponDao)
    }

    @Singleton
    @Provides
    fun provideArmorLocalDataSource(
        armorDao: ArmorDao
    ): ArmorLocalDataSource {
        return ArmorLocalDataSourceImpl(armorDao)
    }
}