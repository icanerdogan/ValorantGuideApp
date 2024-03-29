package com.ibrahimcanerdogan.valorantguideapp.view.dependencyinjection

import com.ibrahimcanerdogan.valorantguideapp.view.adapter.agent.AgentAdapter
import com.ibrahimcanerdogan.valorantguideapp.view.adapter.map.MapAdapter
import com.ibrahimcanerdogan.valorantguideapp.view.adapter.other.armor.ArmorAdapter
import com.ibrahimcanerdogan.valorantguideapp.view.adapter.weapon.WeaponAdapter
import com.ibrahimcanerdogan.valorantguideapp.view.adapter.weapon.WeaponDamageRangeAdapter
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

    @Singleton
    @Provides
    fun provideMapAdapter() : MapAdapter {
        return MapAdapter()
    }

    @Singleton
    @Provides
    fun provideWeaponAdapter() : WeaponAdapter {
        return WeaponAdapter()
    }

    @Singleton
    @Provides
    fun provideWeaponDamageRangeAdapter() : WeaponDamageRangeAdapter {
        return WeaponDamageRangeAdapter()
    }

    @Singleton
    @Provides
    fun provideArmorAdapter() : ArmorAdapter {
        return ArmorAdapter()
    }

}