package com.vivacious.beerace.race.domainimpl.di

import com.vivacious.beerace.race.domain.datasources.RaceRemoteDataSource
import com.vivacious.beerace.race.domain.repositories.RaceRepository
import com.vivacious.beerace.race.domainimpl.repositories.RaceRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideRaceRepository(
        raceRemoteDataSource: RaceRemoteDataSource,
    ): RaceRepository {
        return RaceRepositoryImpl(raceRemoteDataSource)
    }
}