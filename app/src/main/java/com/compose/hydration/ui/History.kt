package com.compose.hydration.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.hydration.viewmodel.HydrationViewModel
import com.compose.hydration.R
import com.compose.hydration.ui.setting.SectionDivider
import com.compose.hydration.viewmodel.HistoryData
import com.compose.hydration.viewmodel.HistoryViewModel


@Composable
fun History(modifier: Modifier = Modifier, viewModel: HistoryViewModel) {
    val state = viewModel.uiState.collectAsState().value
    Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.surface)) {
        LazyColumn {
            items(state.list) { item: HistoryData ->
                HistoryItem(modifier = modifier, data = item)
                Divider(
                    modifier = modifier,
                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.3f)
                )
            }
        }
    }

}

@Composable
fun HistoryItem(modifier: Modifier = Modifier, data: HistoryData) {
    Box(
        contentAlignment = Alignment.Center,
        propagateMinConstraints = true,
        modifier = modifier.fillMaxWidth().padding(horizontal = 8.dp)
    ) {
        Column {
            Text(text = "${data.date}")
            Text(text = "${data.dailyGoal} ${data.units}")
            Text(text = "${data.percentage}% out of ${data.dailyGoal} ${data.units} Goal")
        }
        if (data.percentage >= 100) {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_checkmark_goal),
                contentDescription = null,
                alignment = Alignment.CenterEnd,
                modifier = Modifier.size(30.dp).padding(end = 16.dp)
            )
        }
    }
}

@Preview
@Composable
fun Preview_HistoryItem() {
    HistoryItem(
        modifier = Modifier.fillMaxWidth(),
        HistoryData(dailyGoal = 0, units = "ml", percentage = 10)
    )
}