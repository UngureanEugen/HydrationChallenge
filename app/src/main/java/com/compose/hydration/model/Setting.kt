package com.compose.hydration.model

import androidx.annotation.StringRes
import androidx.datastore.preferences.core.Preferences
import com.compose.hydration.R
import com.compose.hydration.data.HydrationRepository.PreferencesKeys

sealed class Setting(
    val type: String,
    @StringRes val label: Int,
    val key: String
) {

    companion object {
        fun fromString(type: String?): Setting {
            return when (type) {
                Units.type -> Units
                DailyGoal.type -> DailyGoal
                ContainerSmall.type -> ContainerSmall
                ContainerMedium.type -> ContainerMedium
                ContainerLarge.type -> ContainerLarge
                else -> Units
            }
        }
    }
}

object Units : Setting("unit", R.string.setting_units, PreferencesKeys.UNIT.name)

object DailyGoal :
    Setting("dailyGoal", R.string.setting_daily_goal, PreferencesKeys.DAILY_GOAL.name)

object ContainerSmall :
    Setting(
        "containerSmall",
        R.string.setting_container_small,
        PreferencesKeys.CONTAINER_SMALL.name
    )

object ContainerMedium :
    Setting(
        "containerMedium",
        R.string.setting_container_medium,
        PreferencesKeys.CONTAINER_MEDIUM.name
    )

object ContainerLarge :
    Setting(
        "containerLarge",
        R.string.setting_container_large,
        PreferencesKeys.CONTAINER_LARGE.name
    )
