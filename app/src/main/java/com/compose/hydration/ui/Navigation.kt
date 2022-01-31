package com.compose.hydration.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.compose.hydration.EditorViewModel
import com.compose.hydration.HydrationViewModel
import com.compose.hydration.Today
import com.compose.hydration.model.Destination
import com.compose.hydration.model.Setting
import com.compose.hydration.model.Units

@Composable
fun Navigation(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    editorViewModel: EditorViewModel
) {
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
            composable(Destination.History.path) {
                // History
                Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.surface)) {
                    Text(text = "History")
                }
            }
        }
        composable(Destination.Settings.path) {
            val viewModel = hiltViewModel<HydrationViewModel>()
            Settings(modifier = modifier, viewModel = viewModel, onAction = { setting ->
                if (setting == Units) {
                    navController.navigate(Destination.ChangeUnits.path)
                } else {
                    navController.navigate(
                        Destination.SettingEditor.path.replace(
                            "{type}",
                            setting.type
                        )
                    )
                }
            })
        }
        composable(
            Destination.SettingEditor.path,
            arguments = listOf(navArgument("type", builder = { type = NavType.StringType }))
        ) { backStackEntry ->
            val setting = Setting.fromString(backStackEntry.arguments?.getString("type"))
            editorViewModel.use(setting)
            Editor(
                modifier = modifier,
                editorViewModel
            )
        }
        composable(Destination.ChangeUnits.path) {
            val viewModel = hiltViewModel<HydrationViewModel>()
            ChangeUnitsItem(modifier, viewModel)
        }
    }
}