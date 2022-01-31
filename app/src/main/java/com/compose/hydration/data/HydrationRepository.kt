package com.compose.hydration.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import com.compose.hydration.model.HydrationState
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class HydrationRepository @Inject constructor(private val dataStore: DataStore<Preferences>) {

    object PreferencesKeys {
        val DAILY_GOAL = intPreferencesKey("daily_goal")
        val UNIT = stringPreferencesKey("unit")
        val CONTAINER_SMALL = intPreferencesKey("container_small")
        val CONTAINER_MEDIUM = intPreferencesKey("container_medium")
        val CONTAINER_LARGE = intPreferencesKey("container_large")
    }

    val preferencesFlow: Flow<HydrationState> = dataStore.data.map { preferences ->
        mapPreferences(preferences)
    }

    private fun mapPreferences(preferences: Preferences): HydrationState {
        val unit = preferences[PreferencesKeys.UNIT] ?: "ml"
        val dailyGoal = preferences[PreferencesKeys.DAILY_GOAL] ?: 2000
        val small = preferences[PreferencesKeys.CONTAINER_SMALL] ?: 200
        val medium = preferences[PreferencesKeys.CONTAINER_MEDIUM] ?: 400
        val large = preferences[PreferencesKeys.CONTAINER_LARGE] ?: 500
        return HydrationState(dailyGoal, unit, small, medium, large)
    }

    suspend fun update(key: String, value: Int) {
        dataStore.edit { preferences ->
            preferences[intPreferencesKey(key)] = value
        }
    }

    suspend fun updateUnits(value: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.UNIT] = value
        }
    }
}