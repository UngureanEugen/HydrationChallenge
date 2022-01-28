package com.compose.hydration.ui

import android.webkit.WebHistoryItem
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.hydration.R

@Composable
fun HistoryItem(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        propagateMinConstraints = true,
        modifier = modifier.fillMaxWidth().padding(horizontal = 8.dp)
    ) {
        Column {
            Text(text = "saturday, 1 January")
            Text(text = "2000 ml")
            Text(text = "100% out of 2000 ml Goal")
        }
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_checkmark_goal),
            contentDescription = null,
            alignment = Alignment.CenterEnd
        )
    }
}

@Preview
@Composable
fun Preview_HistoryItem() {
    HistoryItem(modifier = Modifier.fillMaxWidth())
}