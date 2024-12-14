package com.vivacious.beerace.race.presentation.race

import com.vivacious.beerace.race.domain.models.RaceStatus

data class RaceScreenUIState(
    val startTime: Int? = null,
    var error: String? = null,
    val status: RaceStatus? = null
)