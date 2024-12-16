package com.vivacious.beerace.race.presentation.home

sealed class HomeScreenEvent {
    object StartBeeRace : HomeScreenEvent()
    object ResetTimer : HomeScreenEvent()
}