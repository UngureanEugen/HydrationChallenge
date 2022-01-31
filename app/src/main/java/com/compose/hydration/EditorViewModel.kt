package com.compose.hydration

import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.hydration.data.HydrationRepository
import com.compose.hydration.model.DailyGoal
import com.compose.hydration.model.EditorState
import com.compose.hydration.model.HydrationState
import com.compose.hydration.model.Setting
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

    fun with(setting: Setting) = viewModelScope.launch {
        uiState.emit(uiState.value.copy(setting = setting))
    }
}