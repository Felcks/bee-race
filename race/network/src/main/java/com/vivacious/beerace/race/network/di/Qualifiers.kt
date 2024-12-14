package com.vivacious.beerace.race.network.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class RaceRetrofit

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class RaceOkHttpClient

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class InterceptorLogging