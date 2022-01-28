package com.compose.hydration.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import com.compose.hydration.Tags.TAG_BOTTOM_NAVIGATION
import com.compose.hydration.model.Destination
import com.compose.hydration.model.NavigationItem.Companion.buildNavigationItems
import com.compose.hydration.ui.theme.HydrationChallengeTheme

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    currentDestination: Destination,
    onNavigate: (destination: Destination) -> Unit
) {
    BottomNavigation(modifier = modifier.testTag(TAG_BOTTOM_NAVIGATION)) {
        buildNavigationItems(
            currentDestination = currentDestination,
            onNavigate = onNavigate
        ).forEach { destination ->
            BottomNavigationItem(
                selected = destination.selected,
                icon = { destination.icon() },
                label = { destination.label() },
                onClick = { destination.onClick() },
                selectedContentColor = MaterialTheme.colors.primary,
                unselectedContentColor = MaterialTheme.colors.onSurface
            )
        }
    }
}

@Preview
@Composable
fun Preview_BottomNavigationBar() {
    HydrationChallengeTheme {
        BottomNavigationBar(
            modifier = Modifier.fillMaxWidth(),
            currentDestination = Destination.Today,
            onNavigate = { }
        )
    }
}