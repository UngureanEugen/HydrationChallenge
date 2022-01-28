package com.compose.hydration.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.hydration.R
import com.compose.hydration.ui.theme.HydrationChallengeTheme

@Composable
fun Settings() {
}

@Composable
fun SettingsList(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        TopAppBar(
            backgroundColor = MaterialTheme.colors.surface,
            contentPadding = PaddingValues(start = 12.dp)
        ) {
            Icon(
                tint = MaterialTheme.colors.onSurface,
                imageVector = Icons.Default.ArrowBack,
                contentDescription = stringResource(id = R.string.settings_back)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                color = MaterialTheme.colors.onSurface,
                fontSize = 18.sp,
                text = stringResource(id = R.string.title_settings)
            )
        }

    }
}

@Preview
@Composable
fun Preview_SettingsList() {
    HydrationChallengeTheme {
        SettingsList(
            modifier = Modifier.fillMaxSize()
        )
    }
}