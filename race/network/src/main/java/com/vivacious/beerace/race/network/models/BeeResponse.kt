package com.vivacious.beerace.race.network.models

import com.google.gson.annotations.SerializedName
import com.vivacious.beerace.race.domain.models.Bee

class BeeResponse(
    @SerializedName("name")
    override val name: String,
    @SerializedName("color")
    override val color: String
) : Bee