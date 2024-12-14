package com.vivacious.beerace.race.network.models

import com.google.gson.annotations.SerializedName
import com.vivacious.beerace.race.domain.models.RaceDuration

class RaceDurationResponse(
    @SerializedName("timeInSeconds")
    override val timeInSeconds: Int
) : RaceDuration