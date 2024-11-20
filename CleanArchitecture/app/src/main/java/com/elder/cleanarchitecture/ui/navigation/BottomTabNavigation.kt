package com.elder.cleanarchitecture.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomTabNavigation(navHostController: NavHostController) {
    val items = listOf(
        BottomNavItem.ScreenOne,
        BottomNavItem.ScreenTwo,
        BottomNavItem.ScreenThree,
        BottomNavItem.ScreenFour
    )
    NavigationBar(
        modifier = Modifier.background(Color.White),
        contentColor = Color.White
    ) {
        val navBackStackEntry by navHostController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        modifier = Modifier
                            .width(25.dp)
                            .height(25.dp)
                    )
                },
                selected = currentRoute == item.route,
                onClick = {
                    navHostController.navigate(item.route) {
                        popUpTo(navHostController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemColors(
                    selectedIconColor = Color.White,
                    selectedTextColor = Color.White,
                    selectedIndicatorColor = Color.Transparent,
                    unselectedIconColor = Color.Gray,
                    unselectedTextColor = Color.Gray,
                    disabledIconColor = Color.DarkGray,
                    disabledTextColor = Color.DarkGray,
                )
            )
        }
    }
}
