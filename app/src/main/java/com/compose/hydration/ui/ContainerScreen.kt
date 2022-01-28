package com.compose.hydration.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ContainerScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            "here you can set your hydration goal based on your preferred unit of measurement",
            textAlign = TextAlign.Center
        )
        Box(modifier = Modifier.fillMaxWidth().weight(1f, fill = true)) {
            OutlinedTextField("df"/*shape = RoundedCornerShape(8.dp)*/, onValueChange = {}, modifier = Modifier.fillMaxWidth())
        }
        Text(
            "here you can set your hydration goal based on your preferred unit of measurement",
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun Preview_Container() {
    ContainerScreen(modifier = Modifier.fillMaxSize())
}