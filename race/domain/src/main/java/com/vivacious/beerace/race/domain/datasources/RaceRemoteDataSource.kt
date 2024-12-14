package com.vivacious.beerace.race.domain.datasources

import com.vivacious.beerace.core.domain.wrapper.Resource
import com.vivacious.beerace.race.domain.models.RaceDuration
import com.vivacious.beerace.race.domain.models.RaceStatus
import kotlinx.coroutines.flow.Flow

interface RaceRemoteDataSource {
    suspend fun getRaceDuration() : Flow<Resource<RaceDuration>>
    suspend fun getRaceStatus() : Flow<Resource<RaceStatus>>
}