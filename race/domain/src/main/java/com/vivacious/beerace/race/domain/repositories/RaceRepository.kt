package com.vivacious.beerace.race.domain.repositories

import com.vivacious.beerace.core.domain.wrapper.Resource
import com.vivacious.beerace.race.domain.models.RaceDuration
import com.vivacious.beerace.race.domain.models.RaceStatus
import kotlinx.coroutines.flow.Flow

interface RaceRepository {
    suspend fun getRaceDuration() : Flow<Resource<RaceDuration>>
    suspend fun getRaceStatus() : Flow<Resource<RaceStatus>>
}