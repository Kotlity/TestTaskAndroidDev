package com.testtask.androiddev.utils

import com.testtask.androiddev.utils.Constants.DESCRIPTION_PATH
import com.testtask.androiddev.utils.Constants.DESCRIPTION_ROUTE
import com.testtask.androiddev.utils.Constants.MAIN_ROUTE

sealed class NavigationRoutes(val route: String) {

    data object MainScreenRoute: NavigationRoutes(MAIN_ROUTE)
    data object DescriptionScreenRoute: NavigationRoutes("$DESCRIPTION_ROUTE/{$DESCRIPTION_PATH}") {
        fun appendArgument(numberInfo: String) = "$DESCRIPTION_ROUTE/$numberInfo"
    }
}