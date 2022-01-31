package com.compose.hydration.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.compose.hydration.EditorViewModel
import com.compose.hydration.R
import com.compose.hydration.model.Destination

@Composable
fun Home(modifier: Modifier = Modifier, orientation: Int) {
    val navController = rememberNavController()
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentDestination by derivedStateOf {
        Destination.fromString(navBackStackEntry.value?.destination?.route)
    }
    val scaffoldState = rememberScaffoldState()
    val editorViewModel = hiltViewModel<EditorViewModel>()
    Scaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        bottomBar = {
            if (currentDestination.isRootDestination) {
                BottomNavigationBar(
                    currentDestination = currentDestination,
                    onNavigate = { destination ->
                        navController.navigate(destination.path) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    })
            }
        },
        topBar = {
            DestinationTopBar(
                modifier = modifier,
                currentDestination = currentDestination,
                onNavigate = { destination ->
                    navController.navigate(destination.path)
                },
                onNavigateUp = {
                    navController.popBackStack()
                },
                onSave = {
                    navController.popBackStack()
                    editorViewModel.save()
                },
                title = stringResource(editorViewModel.uiState.value.setting.label)
            )
        }) {
        Box(modifier = modifier, contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = R.drawable.leaf_bg),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                alpha = 0.5f
            )
            Navigation(
                modifier = Modifier.fillMaxSize(),
                navController = navController,
                editorViewModel
            )
        }
    }
}