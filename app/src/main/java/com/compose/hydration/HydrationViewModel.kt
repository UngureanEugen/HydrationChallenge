package com.compose.hydration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.hydration.data.Hydration
import com.compose.hydration.data.HydrationRepository
import com.compose.hydration.data.HydrationState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.roundToInt

@HiltViewModel
class HydrationViewModel @Inject constructor(
    private val repository: HydrationRepository
) : ViewModel() {

    val uiState = MutableStateFlow(HydrationState())

    init {
        viewModelScope.launch {
            repository.preferencesFlow.collectLatest { state ->
                uiState.value = uiState.value.copy(
                    dailyGoal = state.dailyGoal,
                    units = state.units,
                    containerSmall = state.containerSmall,
                    containerMedium = state.containerMedium,
                    containerLarge = state.containerLarge
                )
            }
        }
        viewModelScope.launch {
            repository.today().collectLatest { hydration ->
                uiState.emit(
                    uiState.value.copy(
                        currentHydration = hydration,
                    )
                )
            }
        }
    }

    fun dailyPercentage(hydration: Hydration?): Int {
        val currentHydration = hydration?.quantity ?: 0
        return ((currentHydration / uiState.value.dailyGoal.toFloat()) * 100).roundToInt()
    }

    fun drink(quantity: Int) = viewModelScope.launch {
        val current = uiState.value.currentHydration
        repository.increaseHydration(current, quantity)
    }

    fun changeUnitType(unitType: String) = viewModelScope.launch {
        repository.updateUnits(unitType)
    }
}