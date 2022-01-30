package com.compose.hydration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.hydration.data.HydrationRepository
import com.compose.hydration.model.HydrationState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditorViewModel @Inject constructor(
    private val repository: HydrationRepository
) : ViewModel() {
    val uiState = MutableStateFlow(HydrationState())

    init {
        viewModelScope.launch {
            repository.preferencesFlow.collectLatest { state ->
                uiState.value = state
            }
        }
    }

    fun saveDailyGoal(goal: Int) = viewModelScope.launch {
        repository.updateDailyGoal(goal)
    }
}