package com.compose.hydration

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.hydration.ui.Glass
import com.compose.hydration.ui.theme.HydrationChallengeTheme

@Composable
fun Today(modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(R.drawable.leaf_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.5f
        )
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
                    .padding(vertical = 32.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = {}, modifier = Modifier.weight(1f, fill = false)) {
                    Text("200 ml", style = MaterialTheme.typography.button)
                }
                Button(
                    onClick = {},
                    modifier = Modifier.weight(1f, fill = false).padding(horizontal = 8.dp)
                ) {
                    Text("400 ml")
                }
                Button(onClick = {}, modifier = Modifier.weight(1f, fill = false)) {
                    Text("500 ml")
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
}

@Preview
@Composable
fun Preview_Today(modifier: Modifier = Modifier) {
    HydrationChallengeTheme {
        Today(modifier = modifier)
    }
}