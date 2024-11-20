package com.elder.cleanarchitecture.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.elder.cleanarchitecture.ui.theme.CleanArchitectureTheme
import com.elder.cleanarchitecture.ui.theme.Pink80

@Composable
fun ScreenTwo() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Pink80)
    ) {
        Text(
            text = "Screen Two",
            style = MaterialTheme.typography.titleLarge,
            color = Color.White,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenTwoPreview() {
    CleanArchitectureTheme {
        ScreenTwo()
    }
}
