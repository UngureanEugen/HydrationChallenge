package com.compose.hydration.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.hydration.ui.theme.HydrationChallengeTheme

@Composable
fun SectionSpacer(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(56.dp)
            .background(MaterialTheme.colors.surface)
    )
}

@Preview
@Composable
fun Preview_SectionSpacer() {
    HydrationChallengeTheme {
        SectionSpacer(modifier = Modifier.fillMaxWidth())
    }
}