package com.vivacious.beerace.race.network.datasources

import com.vivacious.beerace.core.domain.wrapper.Resource
import com.vivacious.beerace.core.network.safeApiCall
import com.vivacious.beerace.race.domain.datasources.RaceRemoteDataSource
import com.vivacious.beerace.race.domain.models.RaceDuration
import com.vivacious.beerace.race.domain.models.RaceStatus
import com.vivacious.beerace.race.network.api.RaceService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

class RaceRemoteDataSourceImpl(
    private val raceService: RaceService,
    private val dispatcher: CoroutineDispatcher,
) : RaceRemoteDataSource {
    override suspend fun getRaceDuration(): Flow<Resource<RaceDuration>> {
        return safeApiCall(dispatcher) {
            raceService.getRaceDuration().body() ?: throw Throwable()
        }
    }

    override suspend fun getRaceStatus(): Flow<Resource<RaceStatus>> {
        return safeApiCall(dispatcher) {
            raceService.getRaceStatus().body() ?: throw Throwable()
        }
    }
}