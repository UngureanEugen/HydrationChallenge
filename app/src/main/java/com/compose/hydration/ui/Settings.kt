package com.compose.hydration.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.hydration.HydrationViewModel
import com.compose.hydration.R
import com.compose.hydration.model.*
import com.compose.hydration.ui.theme.HydrationChallengeTheme

@Composable
fun Settings(
    modifier: Modifier = Modifier,
    viewModel: HydrationViewModel,
    onAction: (Setting) -> Unit
) {
    val state = viewModel.uiState.collectAsState().value
    SettingsList(modifier = modifier, onAction = onAction, state = state)
}

@Composable
fun SettingsList(
    modifier: Modifier = Modifier,
    state: HydrationState,
    onAction: (Setting) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = MaterialTheme.colors.surface)
    ) {
        SectionSpacer(modifier = modifier)
        SettingItem(
            modifier = modifier,
            title = stringResource(R.string.setting_units),
            unit = state.units
        ) { onAction(Units) }
        Divider(modifier = modifier, color = MaterialTheme.colors.onSurface.copy(alpha = 0.3f))
        SettingItem(
            modifier = modifier,
            title = stringResource(R.string.setting_daily_goal),
            value = "${state.dailyGoal}",
            unit = state.units
        ) { onAction(DailyGoal) }
        Divider(modifier = modifier, color = MaterialTheme.colors.onSurface.copy(alpha = 0.3f))
        SectionSpacer(modifier = modifier)
        Text(
            text = stringResource(R.string.setting_containers),
            modifier = Modifier.height(56.dp).padding(start = 16.dp, top = 24.dp),
            color = MaterialTheme.colors.onSecondary,
            style = MaterialTheme.typography.body2,
        )
        SettingItem(
            modifier = modifier,
            title = stringResource(R.string.setting_container_small),
            value = "${state.containerSmall}",
            unit = state.units
        ) {
            onAction(ContainerSmall)
        }
        Divider(modifier = modifier, color = MaterialTheme.colors.onSurface.copy(alpha = 0.3f))
        SettingItem(
            modifier = modifier,
            title = stringResource(R.string.setting_container_medium),
            value = "${state.containerMedium}",
            unit = state.units
        ) { onAction(ContainerMedium) }
        Divider(modifier = modifier, color = MaterialTheme.colors.onSurface.copy(alpha = 0.3f))
        SettingItem(
            modifier = modifier,
            title = stringResource(R.string.setting_container_large),
            value = "${state.containerLarge}",
            unit = state.units
        ) { onAction(ContainerLarge) }
        Divider(modifier = modifier, color = MaterialTheme.colors.onSurface.copy(alpha = 0.3f))
        Text(
            text = stringResource(R.string.setting_description),
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            color = MaterialTheme.colors.onSecondary,
            style = MaterialTheme.typography.body2,
        )
    }
}

@Preview
@Composable
fun Preview_SettingsList() {
    HydrationChallengeTheme {
        SettingsList(
            modifier = Modifier.fillMaxSize(), onAction = {}, state = HydrationState()
        )
    }
}