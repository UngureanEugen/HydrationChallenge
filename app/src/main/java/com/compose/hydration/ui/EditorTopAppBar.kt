package com.compose.hydration.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.hydration.R

@Composable
fun EditorTopAppBar(
    title: String,
    onNavigateUp: () -> Unit, onSave: () -> Unit
) {
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