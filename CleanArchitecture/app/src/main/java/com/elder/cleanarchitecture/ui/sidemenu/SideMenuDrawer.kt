package com.elder.cleanarchitecture.ui.sidemenu

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SideMenuDrawer() {
    ModalDrawerSheet(modifier = Modifier.width(300.dp)) {
        Text("Drawer title", modifier = Modifier.padding(16.dp))
        HorizontalDivider()
        NavigationDrawerItem(
            label = { Text(text = "Drawer Item") },
            selected = false,
            onClick = { }
        )
        NavigationDrawerItem(
            label = { Text(text = "Drawer Item2") },
            selected = false,
            onClick = { }
        )
        // ...other drawer items
    }
}
