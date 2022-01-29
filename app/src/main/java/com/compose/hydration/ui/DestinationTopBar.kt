package com.compose.hydration.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.hydration.R
import com.compose.hydration.model.Destination
import com.compose.hydration.model.Destination.*
import com.compose.hydration.ui.theme.HydrationChallengeTheme

@Composable
fun DestinationTopBar(
    modifier: Modifier = Modifier,
    currentDestination: Destination,
    onNavigate: (destination: Destination) -> Unit,
    onNavigateUp: () -> Unit
) {
    Box {
        Row(
            Modifier.fillMaxWidth()
                .height(56.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            content = {
                AppBar(
                    modifier = modifier,
                    destination = currentDestination,
                    onNavigate = onNavigate,
                    onNavigateUp = onNavigateUp
                )
            }
        )
        Divider(
            color = MaterialTheme.colors.primary,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
private fun AppBar(
    modifier: Modifier,
    destination: Destination,
    onNavigate: (destination: Destination) -> Unit,
    onNavigateUp: () -> Unit
) {
    when (destination) {
        Home, Today -> {
            TopAppBar(modifier = modifier, title = {
                Text(
                    text = "Today's progress",
                    style = MaterialTheme.typography.subtitle1
                )
            }, actions = {
                IconButton(onClick = { onNavigate(Settings) }) {
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
            TopAppBar(
                title = {
                    Text(
                        color = MaterialTheme.colors.onSurface,
                        fontSize = 18.sp,
                        text = stringResource(id = R.string.title_settings)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        onNavigateUp()
                    }) {
                        Icon(
                            tint = MaterialTheme.colors.onSurface,
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = stringResource(id = R.string.settings_back)
                        )
                    }
                },
                backgroundColor = MaterialTheme.colors.surface
            )
        }
    }
}

@Preview
@Composable
fun Preview_DestinationAppBar() {
    HydrationChallengeTheme {
        DestinationTopBar(
            modifier = Modifier,
            currentDestination = Settings,
            onNavigate = {},
            onNavigateUp = {})
    }
}