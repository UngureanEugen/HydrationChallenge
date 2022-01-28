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
import androidx.compose.ui.tooling.preview.Preview
import com.compose.hydration.ui.Glass
import com.compose.hydration.ui.theme.HydrationChallengeTheme

@Composable
fun Today(modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(R.drawable.leaf_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "20%",
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.primaryVariant
            )
            Text(text = "of 2000 ml Goal")
            Glass(modifier = modifier.wrapContentSize())
            Row {
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
}

@Preview
@Composable
fun Preview_Today(modifier: Modifier = Modifier) {
    HydrationChallengeTheme {
        Today(modifier = modifier)
    }
}