package com.compose.hydration.ui

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HistoryChart(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier, onDraw = {
    })
}

@Preview
@Composable
fun Preview_HistoryChart() {
    HistoryChart(modifier = Modifier)
}