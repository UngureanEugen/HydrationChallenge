package com.compose.hydration.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.hydration.R
import com.compose.hydration.ui.theme.HydrationChallengeTheme

@Composable
fun Settings(modifier: Modifier = Modifier, onAction: () -> Unit) {
    SettingsList(modifier = modifier, onAction = onAction)
}

@Composable
fun SettingsList(
    modifier: Modifier = Modifier,
    onAction: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = MaterialTheme.colors.surface)
    ) {
        SectionSpacer(modifier = modifier)
        SettingItem(modifier = modifier, title = "Units", unit = "ml") { onAction() }
        Divider(modifier = modifier, color = MaterialTheme.colors.onSurface.copy(alpha = 0.3f))
        SettingItem(modifier = modifier, title = "Units", unit = "ml") {}
        Divider(modifier = modifier, color = MaterialTheme.colors.onSurface.copy(alpha = 0.3f))
        SectionSpacer(modifier = modifier)
        Text(
            text = "Containers",
            modifier = Modifier.height(56.dp).padding(start = 16.dp, top = 24.dp),
            color = MaterialTheme.colors.onSecondary,
            style = MaterialTheme.typography.body2,
        )
        SettingItem(modifier = modifier, title = "Units", unit = "ml") {}
        Divider(modifier = modifier, color = MaterialTheme.colors.onSurface.copy(alpha = 0.3f))
        SettingItem(modifier = modifier, title = "Units", unit = "ml") {}
        Divider(modifier = modifier, color = MaterialTheme.colors.onSurface.copy(alpha = 0.3f))
        SettingItem(modifier = modifier, title = "Units", unit = "ml") {}
        Divider(modifier = modifier, color = MaterialTheme.colors.onSurface.copy(alpha = 0.3f))
        Text(
            text = "These containers will appear on your main screen so you can easily tap on them and track your intake.",
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
            modifier = Modifier.fillMaxSize(), onAction = {}
        )
    }
}