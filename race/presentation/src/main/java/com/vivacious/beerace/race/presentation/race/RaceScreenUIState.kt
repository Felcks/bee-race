package com.vivacious.beerace.race.presentation.race

import com.vivacious.beerace.race.domain.models.Bee
import com.vivacious.beerace.race.domain.models.RaceStatus

data class RaceScreenUIState(
    var error: String? = null,
    val status: RaceStatus? = null,
    var currentTime: Int? = null,
    var winner: Bee? = null
)