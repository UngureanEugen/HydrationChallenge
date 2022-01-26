package com.compose.hydration

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.compose.hydration.model.Destination

@Preview
@Composable
fun Today(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "20%")
        Text(text = "of 2000 ml Goal")
        // Glass
        Row() {
            Button(onClick = {}) {
                Text("container 1")
            }
            Button(onClick = {}) {
                Text("container 1")
            }
            Button(onClick = {}) {
                Text("container 1")
            }
        }
        Text(text = "Happy you'are back to track your healthy habit of staying hydrated")
    }
}