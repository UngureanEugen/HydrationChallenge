package com.compose.hydration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.hydration.data.HydrationRepository
import com.compose.hydration.data.HydrationState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HydrationViewModel @Inject constructor(
    private val repository: HydrationRepository
) : ViewModel() {

    val uiState = MutableStateFlow(HydrationState())

    init {
        viewModelScope.launch {
            repository.preferencesFlow.collectLatest { state ->
                uiState.value = state
            }
        }
        viewModelScope.launch {
            repository.today().collectLatest {
                uiState.emit(uiState.value.copy(currentHydration = it))
            }
        }
    }

    fun drink(quantity: Int) = viewModelScope.launch {
        val current = uiState.value.currentHydration
        repository.increaseHydration(current, quantity)
    }

    fun changeUnitType(unitType: String) = viewModelScope.launch {
        repository.updateUnits(unitType)
    }
}