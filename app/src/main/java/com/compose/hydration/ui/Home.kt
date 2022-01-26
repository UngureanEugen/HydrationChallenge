package com.compose.hydration.ui


import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.compose.hydration.model.Destination

@Composable
fun Home(modifier: Modifier = Modifier, orientation: Int) {
    val navController = rememberNavController()
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentDestination by derivedStateOf {
        Destination.fromString(navBackStackEntry.value?.destination?.route)
    }
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(modifier = modifier, scaffoldState = scaffoldState, /*TopAppBar*/ bottomBar = {

    }) {

    }
}