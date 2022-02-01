package com.compose.hydration.ui


import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.compose.hydration.HydrationViewModel
import com.compose.hydration.R
import com.compose.hydration.ui.theme.HydrationChallengeTheme

@Composable
fun TodayItem(modifier: Modifier = Modifier, viewModel: HydrationViewModel) {
    val state = viewModel.uiState.collectAsState().value
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "${viewModel.dailyPercentage(state.currentHydration)}%",
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.primary
        )
        Text(
            text = "of ${state.dailyGoal} ${state.units} Goal",
            style = MaterialTheme.typography.body2,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Glass(
            quantity = state.currentHydration?.quantity ?: 0,
            units = state.units,
            progress = (viewModel.dailyPercentage(state.currentHydration) / 100f)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 32.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { viewModel.drink(state.containerSmall) },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "${state.containerSmall} ${state.units}")
            }
            Spacer(Modifier.width(8.dp))
            Button(
                onClick = { viewModel.drink(state.containerMedium) },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "${state.containerMedium} ${state.units}")
            }
            Spacer(Modifier.width(8.dp))
            Button(
                onClick = { viewModel.drink(state.containerLarge) },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "${state.containerLarge} ${state.units}")
            }
        }
        Text(
            text = stringResource(R.string.today_description),
            modifier = Modifier.fillMaxWidth(0.7f),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body2
        )
    }
}

@Preview
@Composable
fun Preview_Today(modifier: Modifier = Modifier) {
    HydrationChallengeTheme {
        TodayItem(modifier = modifier, viewModel = viewModel())
    }
}