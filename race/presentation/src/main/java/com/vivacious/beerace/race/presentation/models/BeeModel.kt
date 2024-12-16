package com.vivacious.beerace.race.presentation.models

import android.os.Parcelable
import com.vivacious.beerace.race.domain.models.Bee
import kotlinx.parcelize.Parcelize

@Parcelize
data class BeeModel(
    override val name: String,
    override val color: String
) : Bee, Parcelable {
    companion object {
        fun fromAdapter(bee: Bee) = BeeModel(bee.name, bee.color)
    }
}