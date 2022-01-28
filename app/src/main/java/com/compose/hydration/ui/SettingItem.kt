package com.compose.hydration.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.hydration.ui.theme.HydrationChallengeTheme

@Composable
fun SettingItem(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Surface(modifier = modifier.heightIn(min = 56.dp)) {
        content()
        Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Units",
                style = MaterialTheme.typography.body1,
                modifier = modifier
                    .weight(1f)
                    .padding(16.dp)
            )
            Text(
                text = "200",
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.primary
            )
            Text(
                text = "ml",
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(start = 8.dp)
            )
            Image(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null,
                modifier = Modifier.padding(end = 8.dp),
                colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onSurface)
            )
        }
    }
}

@Preview
@Composable
fun PreviewSettingItem() {
    HydrationChallengeTheme {
        SettingItem { }
    }
}