package com.compose.hydration.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.compose.hydration.EditorViewModel
import com.compose.hydration.HydrationViewModel
import com.compose.hydration.R
import com.compose.hydration.model.Setting
import com.compose.hydration.model.Units
import com.compose.hydration.ui.theme.HydrationChallengeTheme

@Composable
fun Editor(modifier: Modifier = Modifier, viewModel: EditorViewModel) {
    val uiState = viewModel.uiState.collectAsState().value

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            stringResource(R.string.goal_description),
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
                uiState.quantity,
                onValueChange = {viewModel.update(it)},
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
                //todo map units
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
        Editor(modifier = Modifier.fillMaxSize(), viewModel = viewModel())
    }
}