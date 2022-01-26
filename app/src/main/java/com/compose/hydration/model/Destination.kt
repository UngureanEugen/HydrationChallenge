package com.compose.hydration.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destination(
    val path: String,
    val icon: ImageVector? = null,
    val isRootDestination: Boolean = true
) {
    companion object {
        fun fromString(route: String?): Destination {
            return when (route) {
                History.path -> History
                Settings.path -> Settings
                DailyGoal.path -> DailyGoal
                Container.path -> Container
                else -> Home
            }
        }
    }

    val title = path.replaceFirstChar {
        it.uppercase()
    }

    object Home : Destination("home")

    object History : Destination("history")

    object Settings : Destination("settings", Icons.Default.ArrowBack, false)

    object DailyGoal : Destination("dailyGoal")

    object Container : Destination("Container")
}