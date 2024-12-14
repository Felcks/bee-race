package com.vivacious.beerace.race.network.di

import com.vivacious.beerace.race.network.api.RaceService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    @Singleton
    fun provideDogsService(@RaceRetrofit retrofit: Retrofit): RaceService =
        retrofit.create(RaceService::class.java)
}