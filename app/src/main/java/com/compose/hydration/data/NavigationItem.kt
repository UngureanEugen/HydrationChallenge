package com.compose.hydration.data

import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource

class NavigationItem(
    val selected: Boolean,
    val onClick: () -> Unit,
    val icon: @Composable () -> Unit,
    val label: @Composable () -> Unit
) {
    companion object {
        fun buildNavigationItems(
            currentDestination: Destination,
            onNavigate: (destination: Destination) -> Unit
        ): List<NavigationItem> {
            return listOf(Destination.Today, Destination.History).map { destination ->
                NavigationItem(
                    selected = currentDestination == destination,
                    label = {
                        Text(text = destination.title)
                    },
                    icon = {
                        destination.icon?.let { image ->
                            Icon(
                                imageVector = ImageVector.vectorResource(id = image),
                                contentDescription = destination.path
                            )
                        }
                    },
                    onClick = {
                        onNavigate(destination)
                    }
                )
            }
        }
    }
}