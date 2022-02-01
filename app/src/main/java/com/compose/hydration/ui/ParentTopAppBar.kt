package com.compose.hydration.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign

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