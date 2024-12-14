package com.vivacious.beerace.race.domainimpl.usecases

import com.vivacious.beerace.core.domain.wrapper.Resource
import com.vivacious.beerace.race.domain.models.RaceStatus
import com.vivacious.beerace.race.domain.repositories.RaceRepository
import com.vivacious.beerace.race.domain.usecases.GetRaceStatusUseCase
import kotlinx.coroutines.flow.Flow

class GetRaceStatusUseCaseImpl(
    private val raceRepository: RaceRepository
) : GetRaceStatusUseCase {
    override suspend fun invoke(): Flow<Resource<RaceStatus>> {
        return raceRepository.getRaceStatus()
    }
}