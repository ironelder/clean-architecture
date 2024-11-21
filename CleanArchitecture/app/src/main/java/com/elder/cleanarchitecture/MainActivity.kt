package com.elder.cleanarchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.elder.cleanarchitecture.ui.navigation.BottomNavigationGraph
import com.elder.cleanarchitecture.ui.navigation.BottomTabNavigation
import com.elder.cleanarchitecture.ui.sidemenu.SideMenuButton
import com.elder.cleanarchitecture.ui.sidemenu.SideMenuDrawer
import com.elder.cleanarchitecture.ui.theme.CleanArchitectureTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CleanArchitectureTheme {
                MainScreenView()
            }
        }
    }
}

@Composable
fun MainScreenView() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    CleanArchitectureTheme {
        ModalNavigationDrawer(
            drawerState = drawerState,
            gesturesEnabled = true,
            drawerContent = { SideMenuDrawer() }
        ) {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = {
                },
                bottomBar = { BottomTabNavigation(navHostController = navController) }
            ) { innerPadding ->
                Box(modifier = Modifier.padding(innerPadding)) {
                    BottomNavigationGraph(navController = navController)
                    SideMenuButton {
                        scope.launch {
                            if (drawerState.isOpen) {
                                drawerState.close()
                            } else {
                                drawerState.open()
                            }
                        }
                    }
                }
            }
        }
    }


}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CleanArchitectureTheme {
        Greeting("Android")
    }
}
