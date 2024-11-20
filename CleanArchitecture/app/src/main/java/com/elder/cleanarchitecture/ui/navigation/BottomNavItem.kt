package com.elder.cleanarchitecture.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val title: String, val icon: ImageVector, val route: String) {
    object ScreenOne : BottomNavItem("ONE", Icons.Default.Home, BOTTOM_NAV_SCREEN_ONE)
    object ScreenTwo : BottomNavItem("TWO", Icons.Default.Star, BOTTOM_NAV_SCREEN_TWO)
    object ScreenThree : BottomNavItem("THREE", Icons.Default.Person, BOTTOM_NAV_SCREEN_THREE)
    object ScreenFour : BottomNavItem("FOUR", Icons.Default.Settings, BOTTOM_NAV_SCREEN_FOUR)
}

private const val BOTTOM_NAV_SCREEN_ONE = "ScreenOne"
private const val BOTTOM_NAV_SCREEN_TWO = "ScreenTwo"
private const val BOTTOM_NAV_SCREEN_THREE = "ScreenThree"
private const val BOTTOM_NAV_SCREEN_FOUR = "ScreenFour"
