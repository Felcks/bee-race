package com.vivacious.beerace.race.network.models

import com.google.gson.annotations.SerializedName
import com.vivacious.beerace.race.domain.models.RaceStatus

class RaceStatusResponse(
    @SerializedName("beeList")
    override val bees: List<BeeResponse>
) : RaceStatus