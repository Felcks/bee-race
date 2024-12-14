package com.vivacious.beerace.race.domainimpl.di

import com.vivacious.beerace.race.domain.repositories.RaceRepository
import com.vivacious.beerace.race.domain.usecases.GetRaceDurationUseCase
import com.vivacious.beerace.race.domain.usecases.GetRaceStatusUseCase
import com.vivacious.beerace.race.domainimpl.usecases.GetRaceDurationUseCaseImpl
import com.vivacious.beerace.race.domainimpl.usecases.GetRaceStatusUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideRaceDurationUseCase(
        raceRepository: RaceRepository
    ): GetRaceDurationUseCase {
        return GetRaceDurationUseCaseImpl(raceRepository)
    }

    @Provides
    @Singleton
    fun provideRaceStatusUseCase(
        raceRepository: RaceRepository
    ): GetRaceStatusUseCase {
        return GetRaceStatusUseCaseImpl(raceRepository)
    }
}