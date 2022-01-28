package com.compose.hydration.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.hydration.R
import com.compose.hydration.model.Destination
import com.compose.hydration.model.Destination.*
import com.compose.hydration.ui.theme.HydrationChallengeTheme

@Composable
fun DestinationTopBar(
    modifier: Modifier = Modifier,
    currentDestination: Destination
) {
    HydrationChallengeTheme {
        Box {
            Row(
                Modifier.fillMaxWidth()
                    .height(56.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                content = {
                    AppBar(modifier = modifier, destination = currentDestination)
                }
            )
            Divider(
                color = MaterialTheme.colors.primary,
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }
}

@Composable
private fun AppBar(modifier: Modifier, destination: Destination) {
    when (destination) {
        Home, Today -> {
            TopAppBar(modifier = modifier, title = {
                Text(
                    text = "Today's progress",
                    style = MaterialTheme.typography.subtitle1
                )
            }, actions = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = stringResource(id = R.string.title_settings),
                        tint = MaterialTheme.colors.primary
                    )
                }
            })
        }
        Container -> {
            Text("kdlf")
        }
        DailyGoal -> {
            Text("kdlf")
        }
        History -> {
            Text("kdlf")
        }
        Settings -> {
            Text("kdlf")
        }
    }
}

@Preview
@Composable
fun Preview_DestinationAppBar() {
    DestinationTopBar(modifier = Modifier, currentDestination = Today)
}