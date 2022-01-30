package com.compose.hydration.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.compose.hydration.EditorViewModel
import com.compose.hydration.ui.theme.HydrationChallengeTheme
import kotlin.math.min

@Composable
fun Editor(modifier: Modifier = Modifier) {
    val viewModel: EditorViewModel = viewModel()
    val uiState = viewModel.uiState.collectAsState()
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            "Here you can set your hydration goal based on your preferred unit of measurement",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(0.65f).padding(top = 32.dp),
            style = MaterialTheme.typography.body2
        )
        Column(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(fraction = 0.6f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                "${uiState.value.dailyGoal}",
                onValueChange = {viewModel.saveDailyGoal(it.toInt())},
                textStyle = MaterialTheme.typography.h4.copy(
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.border(
                    3.dp,
                    MaterialTheme.colors.primary,
                    MaterialTheme.shapes.medium
                ),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    cursorColor = MaterialTheme.colors.onSurface
                )
            )
            Text(
                "milliliters (ml)",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(all = 8.dp)
            )
        }
    }
}

@Preview
@Composable
fun Preview_Container() {
    HydrationChallengeTheme {
        Editor(modifier = Modifier.fillMaxSize())
    }
}