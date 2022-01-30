package com.compose.hydration.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.compose.hydration.model.HydrationState
import com.compose.hydration.utility.Constants
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class HydrationRepository @Inject constructor(private val dataStore: DataStore<Preferences>) {

    private object PreferencesKeys {
        val DAILY_GOAL = intPreferencesKey("daily_goal")
        val UNIT = stringPreferencesKey("unit")
    }

    val preferencesFlow: Flow<HydrationState> = dataStore.data.map { preferences ->
        mapPreferences(preferences)
    }

    private fun mapPreferences(preferences: Preferences): HydrationState {
        val unit = preferences[PreferencesKeys.UNIT] ?: "ml"
        val dailyGoal = preferences[PreferencesKeys.DAILY_GOAL] ?: 2000
        return HydrationState(dailyGoal, unit)
    }

    suspend fun updateDailyGoal(goal: Int) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.DAILY_GOAL] = goal
        }
    }
}