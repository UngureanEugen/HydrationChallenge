package com.compose.hydration.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.compose.hydration.R

@Composable
fun ChildTopAppBar(@StringRes label: Int, onNavigateUp: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                color = MaterialTheme.colors.onSurface,
                fontSize = 18.sp,
                text = stringResource(id = label),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(0.8f)
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