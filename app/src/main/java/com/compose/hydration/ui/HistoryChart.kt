package com.compose.hydration.ui

import android.view.View
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun HistoryChart(modifier: Modifier = Modifier) {
    //todo import bar chart library here
    AndroidView(factory = {
        View(it)
    }, modifier = modifier)
}

@Preview
@Composable
fun Preview_HistoryChart() {
    HistoryChart(modifier = Modifier)
}