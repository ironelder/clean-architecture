package com.elder.cleanarchitecture.ui.sidemenu

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SideMenuButton(onClick: () -> Unit) {
    // Button to open the side menu
    FloatingActionButton(
        modifier = Modifier.background(Color.Transparent),
        elevation = FloatingActionButtonDefaults.elevation(
            defaultElevation = 0.dp, // 기본 그림자 제거
            pressedElevation = 0.dp, // 클릭 시 그림자 제거
            focusedElevation = 0.dp, // 포커스 상태 그림자 제거
            hoveredElevation = 0.dp // 호버 상태 그림자 제거
        ),
        containerColor = Color.Transparent,
        interactionSource = remember { MutableInteractionSource() },
        onClick = onClick
    ) {
        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
    }
}
