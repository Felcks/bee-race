package com.vivacious.beerace.race.presentation.components

import androidx.compose.ui.graphics.Color

object HexToJetpackColor {
    fun getColor(colorString: String): Color {
        return Color(android.graphics.Color.parseColor(colorString))
    }
}