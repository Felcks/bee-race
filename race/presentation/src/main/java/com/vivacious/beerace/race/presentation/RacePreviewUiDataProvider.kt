package com.vivacious.beerace.race.presentation

import com.vivacious.beerace.race.domain.models.Bee

class RacePreviewUiDataProvider() {
    val bees = listOf(
        object : Bee {
            override val name: String = "BeeWare"
            override val color: String = "#86a162"

        },
        object : Bee {
            override val name: String = "BeeM"
            override val color: String = "#d68b6b"

        },
        object : Bee {
            override val name: String = "BeeKeep"
            override val color: String = "#eff7a3"

        },
        object : Bee {
            override val name: String = "BeeLow"
            override val color: String = "#bfde64"

        }
    )
}