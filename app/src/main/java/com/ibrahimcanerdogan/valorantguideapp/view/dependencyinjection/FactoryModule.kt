package com.ibrahimcanerdogan.valorantguideapp.view.dependencyinjection

import android.app.Application
import com.ibrahimcanerdogan.valorantguideapp.domain.usecase.agent.GetAgentUseCase
import com.ibrahimcanerdogan.valorantguideapp.domain.usecase.map.GetMapUseCase
import com.ibrahimcanerdogan.valorantguideapp.domain.usecase.other.armor.GetArmorUseCase
import com.ibrahimcanerdogan.valorantguideapp.domain.usecase.weapon.GetWeaponUseCase
import com.ibrahimcanerdogan.valorantguideapp.view.viewmodel.agent.AgentViewModelFactory
import com.ibrahimcanerdogan.valorantguideapp.view.viewmodel.map.MapViewModelFactory
import com.ibrahimcanerdogan.valorantguideapp.view.viewmodel.other.armor.ArmorViewModelFactory
import com.ibrahimcanerdogan.valorantguideapp.view.viewmodel.weapon.WeaponViewModelFactory
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

    @Singleton
    @Provides
    fun provideWeaponViewModelFactory(
        application: Application,
        getWeaponUseCase: GetWeaponUseCase
    ) : WeaponViewModelFactory {
        return WeaponViewModelFactory(
            application,
            getWeaponUseCase
        )
    }

    @Singleton
    @Provides
    fun provideArmorViewModelFactory(
        application: Application,
        getArmorUseCase: GetArmorUseCase
    ) : ArmorViewModelFactory {
        return ArmorViewModelFactory(
            application,
            getArmorUseCase
        )
    }
}