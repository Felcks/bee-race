package com.vivacious.beerace.race.domain.usecases

import com.vivacious.beerace.core.domain.wrapper.Resource
import com.vivacious.beerace.race.domain.models.RaceStatus
import kotlinx.coroutines.flow.Flow

interface GetRaceStatusUseCase {
    suspend operator fun invoke() : Flow<Resource<RaceStatus>>
}