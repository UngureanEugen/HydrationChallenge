package com.compose.hydration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.hydration.data.HydrationRepository
import com.compose.hydration.model.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditorViewModel @Inject constructor(
    private val repository: HydrationRepository
) : ViewModel() {
    val uiState = MutableStateFlow(EditorState())

    init {
        viewModelScope.launch {
            repository.preferencesFlow.collectLatest { state ->
//                uiState.value = state
            }
        }
    }

    fun save() = viewModelScope.launch {
        repository.update(uiState.value.setting.key, uiState.value.quantity.toInt())
    }

    fun update(quantity: String) = viewModelScope.launch {
        uiState.emit(uiState.value.copy(quantity = quantity))
    }

    fun modify(setting: Setting) = viewModelScope.launch {
        repository.preferencesFlow.collectLatest { prefs ->
            val quantity = when (setting) {
                ContainerLarge -> prefs.containerLarge
                ContainerMedium -> prefs.containerMedium
                ContainerSmall -> prefs.containerSmall
                DailyGoal -> prefs.dailyGoal
                Units -> 0
            }
            val units = prefs.units
            uiState.value = uiState.value.copy(
                quantity = quantity.toString(), unit = units, setting = setting
            )
        }
    }
}