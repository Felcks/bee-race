package com.vivacious.beerace.race.domainimpl.repositories

import com.vivacious.beerace.core.domain.wrapper.Resource
import com.vivacious.beerace.race.domain.datasources.RaceRemoteDataSource
import com.vivacious.beerace.race.domain.models.RaceDuration
import com.vivacious.beerace.race.domain.models.RaceStatus
import com.vivacious.beerace.race.domain.repositories.RaceRepository
import kotlinx.coroutines.flow.Flow

class RaceRepositoryImpl (
    private val raceRemoteDataSource: RaceRemoteDataSource
): RaceRepository {
    override suspend fun getRaceDuration(): Flow<Resource<RaceDuration>> {
        return raceRemoteDataSource.getRaceDuration()
    }

    override suspend fun getRaceStatus(): Flow<Resource<RaceStatus>> {
        return raceRemoteDataSource.getRaceStatus()
    }
}