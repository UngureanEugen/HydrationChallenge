package com.compose.hydration.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.hydration.data.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val repository: HydrationRepository
) : ViewModel() {
    val uiState = MutableStateFlow(HistoryState())

    init {
        viewModelScope.launch {
            repository.getHistory(30).combine(repository.preferencesFlow) { historyItems, prefs ->
                historyItems.map { item ->
                    HistoryData(
                        item.day,
                        prefs.dailyGoal,
                        prefs.units,
                        item.dailyPercentage(prefs.dailyGoal.toFloat())
                    )
                }
            }.collectLatest { items ->
                uiState.emit(uiState.value.copy(items))
            }

        }
    }
}

data class HistoryState(
    val list: List<HistoryData> = emptyList()
)

data class HistoryData(
    val date: Date = Date(),
    val dailyGoal: Int,
    val units: String,
    val percentage: Int
) {
    fun formatHistoryDate(): String {
        return ""
    }
}
