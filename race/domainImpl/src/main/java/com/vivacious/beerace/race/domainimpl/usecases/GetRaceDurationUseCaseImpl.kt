package com.vivacious.beerace.race.domainimpl.usecases

import com.vivacious.beerace.core.domain.wrapper.Resource
import com.vivacious.beerace.race.domain.models.RaceDuration
import com.vivacious.beerace.race.domain.repositories.RaceRepository
import com.vivacious.beerace.race.domain.usecases.GetRaceDurationUseCase
import kotlinx.coroutines.flow.Flow

class GetRaceDurationUseCaseImpl(
    private val raceRepository: RaceRepository
) : GetRaceDurationUseCase {
    override suspend fun invoke(): Flow<Resource<RaceDuration>> {
        return raceRepository.getRaceDuration()
    }
}