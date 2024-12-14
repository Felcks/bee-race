package com.vivacious.beerace.race.network.api

import com.vivacious.beerace.race.network.models.RaceDurationResponse
import com.vivacious.beerace.race.network.models.RaceStatusResponse
import retrofit2.Response
import retrofit2.http.GET

interface RaceService {

    @GET("bees/race/duration")
    suspend fun getRaceDuration(): Response<RaceDurationResponse>

    @GET("bees/race/status")
    suspend fun getRaceStatus(): Response<RaceStatusResponse>
}