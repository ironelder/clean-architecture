package com.elder.cleanarchitecture.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.elder.cleanarchitecture.ui.screen.ScreenFour
import com.elder.cleanarchitecture.ui.screen.ScreenOne
import com.elder.cleanarchitecture.ui.screen.ScreenThree
import com.elder.cleanarchitecture.ui.screen.ScreenTwo

@Composable
fun BottomNavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavItem.ScreenOne.route) {
        composable(BottomNavItem.ScreenOne.route) {
            ScreenOne()
        }
        composable(BottomNavItem.ScreenTwo.route) {
            ScreenTwo()
        }
        composable(BottomNavItem.ScreenThree.route) {
            ScreenThree()
        }
        composable(BottomNavItem.ScreenFour.route) {
            ScreenFour()
        }
    }
}
