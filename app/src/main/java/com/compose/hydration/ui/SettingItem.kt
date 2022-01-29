package com.compose.hydration.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import com.compose.hydration.ui.theme.Antracit
import com.compose.hydration.ui.theme.Gray
import com.compose.hydration.ui.theme.GrayDark
import com.compose.hydration.ui.theme.HydrationChallengeTheme

@Composable
fun SettingItem(
    modifier: Modifier = Modifier,
    title: String,
    value: String? = null,
    unit: String,
    onSettingAction: () -> Unit
) {
    Surface(
        modifier = modifier
            .heightIn(min = 56.dp).clickable {
                onSettingAction()
            }
    ) {
        Row(
            modifier = modifier.background(MaterialTheme.colors.secondary),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.body1,
                modifier = modifier
                    .weight(1f)
                    .padding(16.dp)
            )
            value?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.primary
                )
            }
            Text(
                text = unit,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(start = 8.dp),
                color = MaterialTheme.colors.onSecondary
            )
            Image(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null,
                modifier = Modifier.padding(end = 8.dp),
                colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onSecondary)
            )
        }
    }
}

@Preview
@Composable
fun PreviewSettingItem() {
    HydrationChallengeTheme {
        SettingItem(modifier = Modifier, title = "Units", value = "3000", unit = "ml") {

        }
    }
}