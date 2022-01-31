package com.compose.hydration.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import com.compose.hydration.R

sealed class Destination(
    val path: String,
    val icon: Int? = null,
    val isRootDestination: Boolean = true
) {
    companion object {
        fun fromString(route: String?): Destination {
            return when (route) {
                Today.path -> Today
                History.path -> History
                Settings.path -> Settings
                SettingEditor.path -> SettingEditor
                ChangeUnits.path -> ChangeUnits
                else -> Home
            }
        }
    }

    val title = path.replaceFirstChar {
        it.uppercase()
    }

    object Home : Destination("home")

    object Today : Destination("today", R.drawable.ic_today)

    object History : Destination("history", R.drawable.ic_history)

    object Settings : Destination("settings",isRootDestination = false)

    object SettingEditor : Destination("setting/{type}", isRootDestination = false)

    object ChangeUnits : Destination("units",isRootDestination = false)
}