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
import com.compose.hydration.model.DailyGoal
import com.compose.hydration.model.Destination
import com.compose.hydration.model.Destination.*
import com.compose.hydration.ui.theme.HydrationChallengeTheme

@Composable
fun DestinationTopBar(
    modifier: Modifier = Modifier,
    currentDestination: Destination,
    title: String,
    onNavigate: (destination: Destination) -> Unit,
    onNavigateUp: () -> Unit,
    onSave: () -> Unit
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
                    title = title,
                    onNavigate = onNavigate,
                    onNavigateUp = onNavigateUp,
                    onSave = onSave
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
    title: String,
    onNavigate: (destination: Destination) -> Unit,
    onNavigateUp: () -> Unit,
    onSave: () -> Unit
) {
    when (destination) {
        Home, Today -> {
            TopAppBar(modifier = modifier, title = {
                Text(
                    text = stringResource(R.string.toolbar_today),
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
        SettingEditor -> {
            Row(
                Modifier.fillMaxWidth()
                    .padding(
                        PaddingValues(
                            start = 4.dp,
                            end = 4.dp
                        )
                    ).height(56.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                TextButton(onClick = { onNavigateUp() }) {
                    Text(
                        text = stringResource(R.string.action_cancel),
                        style = MaterialTheme.typography.button
                    )
                }
                Text(
                    text = title,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.subtitle1
                )
                TextButton(onClick = { onSave() }) {
                    Text(
                        text = stringResource(R.string.action_save),
                        style = MaterialTheme.typography.button
                    )
                }
            }
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
            currentDestination = SettingEditor,
            stringResource(DailyGoal.label),
            onNavigate = {},
            onNavigateUp = {}
        ) {}
    }
}