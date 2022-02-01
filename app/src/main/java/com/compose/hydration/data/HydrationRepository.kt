package com.compose.hydration.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import kotlinx.coroutines.flow.*
import java.time.LocalDate
import java.util.*
import javax.inject.Inject

class HydrationRepository @Inject constructor(
    private val dataStore: DataStore<Preferences>,
    private val hydrationDao: HydrationDao
) {

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

    fun today() = hydrationDao.findHydration(currentDateWithoutHours())

    suspend fun increaseHydration(current: Hydration?, quantity: Int) {
        val hydrationLevel = current?.copy(quantity = current.quantity + quantity)
            ?: Hydration(
                quantity = quantity,
                day = currentDateWithoutHours()
            )
        hydrationDao.insert(hydrationLevel)
    }

    private fun currentDateWithoutHours(): Date {
        val calendar: Calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        return calendar.time
    }
}