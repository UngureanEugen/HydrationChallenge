package com.compose.hydration.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.compose.hydration.viewmodel.EditorViewModel
import com.compose.hydration.viewmodel.HydrationViewModel
import com.compose.hydration.data.Destination
import com.compose.hydration.data.Setting
import com.compose.hydration.data.Units
import com.compose.hydration.ui.setting.Settings
import com.compose.hydration.viewmodel.HistoryViewModel

@Composable
fun Navigation(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    editorViewModel: EditorViewModel,
    hydrationViewModel: HydrationViewModel
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Destination.Home.path
    ) {
        navigation(startDestination = Destination.Today.path, route = Destination.Home.path) {
            // Today
            composable(Destination.Today.path) {
                TodayItem(modifier = modifier, hydrationViewModel)
            }
            composable(Destination.History.path) {
                val historyViewModel = hiltViewModel<HistoryViewModel>()
                History(modifier = modifier, viewModel = historyViewModel)
            }
        }
        composable(Destination.Settings.path) {
            Settings(modifier = modifier, viewModel = hydrationViewModel, onAction = { setting ->
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
            ChangeUnitsItem(modifier, hydrationViewModel)
        }
    }
}