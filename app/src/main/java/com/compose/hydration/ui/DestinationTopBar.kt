package com.compose.hydration.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.hydration.R
import com.compose.hydration.data.DailyGoal
import com.compose.hydration.data.Destination
import com.compose.hydration.data.Destination.*
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
            ParentTopAppBar(modifier, R.string.toolbar_today, actions = {
                IconButton(onClick = { onNavigate(Settings) }) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = stringResource(id = R.string.title_settings),
                        tint = MaterialTheme.colors.primary
                    )
                }
            })
        }
        SettingEditor -> EditorTopAppBar(title, onNavigateUp, onSave)
        History ->  ParentTopAppBar(modifier, R.string.toolbar_history, {})
        Settings -> ChildTopAppBar(R.string.title_settings, onNavigateUp)
        ChangeUnits -> ChildTopAppBar(R.string.setting_units, onNavigateUp)
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