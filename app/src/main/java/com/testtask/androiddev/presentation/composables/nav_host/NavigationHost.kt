package com.testtask.androiddev.presentation.composables.nav_host

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.testtask.androiddev.presentation.screens.DescriptionScreen
import com.testtask.androiddev.presentation.screens.MainScreen
import com.testtask.androiddev.presentation.viewmodel.NumbersInfoViewModel
import com.testtask.androiddev.utils.Constants.DEFAULT_NUMBER_INFO_DESCRIPTION
import com.testtask.androiddev.utils.Constants.DESCRIPTION_PATH
import com.testtask.androiddev.utils.NavigationRoutes

@Composable
fun NavigationHost() {

    val navHostController = rememberNavController()

    NavHost(
        navController = navHostController,
        startDestination = NavigationRoutes.MainScreenRoute.route
    ) {
        composable(NavigationRoutes.MainScreenRoute.route) {
            val numbersInfoViewModel = hiltViewModel<NumbersInfoViewModel>()
            val numbersInfoState = numbersInfoViewModel.numbersInfoState
            val navigationEvent = numbersInfoViewModel.navigationFlow

            MainScreen(
                navHostController = navHostController,
                numbersInfoState = numbersInfoState,
                navigationEvent = navigationEvent,
                onNumbersInfoEvent = numbersInfoViewModel::onEvent
            )
        }
        composable(
            NavigationRoutes.DescriptionScreenRoute.route,
            arguments = listOf(
                navArgument(
                    name = DESCRIPTION_PATH
                ) {
                    type = NavType.StringType
                }
            )
        ) { navBackStackEntry ->
            val numberInfo = navBackStackEntry.arguments?.getString(DESCRIPTION_PATH) ?: DEFAULT_NUMBER_INFO_DESCRIPTION
            DescriptionScreen(
                navHostController = navHostController,
                numberInfo = numberInfo
            )
        }
    }
}