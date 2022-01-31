package com.compose.hydration.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.compose.hydration.R
import com.compose.hydration.model.Destination

@Composable
fun ParentTopAppBar(
    modifier: Modifier, @StringRes label: Int,
    actions: @Composable () -> Unit
) {
    TopAppBar(modifier = modifier, title = {
        Text(
            text = stringResource(label),
            style = MaterialTheme.typography.subtitle1,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }, actions = { actions() })
}