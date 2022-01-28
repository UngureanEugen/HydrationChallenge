package com.compose.hydration.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.compose.hydration.Today
import com.compose.hydration.model.Destination

@Composable
fun Navigation(modifier: Modifier = Modifier, navController: NavHostController) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Destination.Home.path
    ) {
        navigation(startDestination = Destination.Today.path, route = Destination.Home.path) {
            // Today
            composable(Destination.Today.path) {
                Today(modifier = modifier)
            }
        }
        composable(Destination.History.path) {
            // History
            Text(text = "History")
        }
    }
}