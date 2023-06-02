package com.ibrahimcanerdogan.valorantguideapp.view.dependencyinjection

import android.app.Application
import androidx.room.Room
import com.ibrahimcanerdogan.valorantguideapp.data.database.ValorantDatabase
import com.ibrahimcanerdogan.valorantguideapp.data.database.agent.AgentDao
import com.ibrahimcanerdogan.valorantguideapp.data.database.map.MapDao
import com.ibrahimcanerdogan.valorantguideapp.util.AppConstant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideValorantDatabase(app : Application) : ValorantDatabase {
        return Room.databaseBuilder(app, ValorantDatabase::class.java, AppConstant.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideAgentDao(valorantDatabase: ValorantDatabase) : AgentDao {
        return valorantDatabase.agentDao()
    }

    @Singleton
    @Provides
    fun provideMapDao(valorantDatabase: ValorantDatabase) : MapDao {
        return valorantDatabase.mapDao()
    }
}