package com.vivacious.beerace.race.network.di

import com.vivacious.beerace.race.domain.datasources.RaceRemoteDataSource
import com.vivacious.beerace.race.network.api.RaceService
import com.vivacious.beerace.race.network.datasources.RaceRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun provideDogsRemoteDataSource(
        raceService: RaceService,
    ): RaceRemoteDataSource {
        return RaceRemoteDataSourceImpl(raceService = raceService, dispatcher = Dispatchers.IO)
    }
}