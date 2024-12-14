package com.vivacious.beerace.race.domain.usecases

import com.vivacious.beerace.core.domain.wrapper.Resource
import com.vivacious.beerace.race.domain.models.RaceDuration
import kotlinx.coroutines.flow.Flow

interface GetRaceDurationUseCase {
    suspend operator fun invoke() : Flow<Resource<RaceDuration>>
}