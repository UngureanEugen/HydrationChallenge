package com.compose.hydration


import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.compose.hydration.ui.Glass
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
            text = "20%",
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.primary
        )
        Text(
            text = "of 2000 ml Goal",
            style = MaterialTheme.typography.body2,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Glass()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 32.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = {}, modifier = Modifier.weight(1f)) {
                Text(text = "${state.containerSmall}")
            }
            Spacer(Modifier.width(8.dp))
            Button(
                onClick = {},
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "${state.containerMedium}")
            }
            Spacer(Modifier.width(8.dp))
            Button(onClick = {}, modifier = Modifier.weight(1f)) {
                Text(text = "${state.containerLarge}")
            }
        }
        Text(
            text = "Happy you'are back to track your healthy habit of staying hydrated",
            modifier = Modifier.padding(horizontal = 32.dp),
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