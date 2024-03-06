package com.example.practicetest

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

sealed class Screen(val route: String) {
    object HomeScreen: Screen(route = "home_screen")
    object DisplayScreen: Screen(route = "display_screen")
}
@Composable
fun NavGraph(navController: NavHostController, viewModel: RepoViewModel) {

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route)

    {

        composable(route = Screen.HomeScreen.route) {
            // Define what should be displayed when navigating to the HomeScreen
            HomeScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = Screen.DisplayScreen.route) {
            // Define what should be displayed when navigating to the DisplayScreen
            DisplayScreen(navController = navController, viewModel = viewModel)
        }
    }

}



@Composable
fun HomeScreen(navController: NavHostController, viewModel: RepoViewModel) {
    Text(text="Inf2007 Quiz 2, Lab123: Teams 2-24")
}

@Composable
fun DisplayScreen(navController: NavHostController, viewModel: RepoViewModel) {
    // Define the UI for the DisplayScreen
}
