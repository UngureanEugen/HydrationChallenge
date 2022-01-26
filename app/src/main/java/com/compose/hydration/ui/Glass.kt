package com.compose.hydration.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun Glass(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier.fillMaxWidth(), onDraw = {
    })
}