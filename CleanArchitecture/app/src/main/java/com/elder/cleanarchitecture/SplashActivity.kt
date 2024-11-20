package com.elder.cleanarchitecture

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.elder.cleanarchitecture.ui.theme.CleanArchitectureTheme
import com.elder.cleanarchitecture.ui.theme.Pink40
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanArchitectureTheme {
                SplashScreen()
            }
        }
    }

    @Preview
    @Composable
    fun SplashScreen() {
        val alpha = remember {
            Animatable(0f)
        }
        LaunchedEffect(key1 = Unit) {
            alpha.animateTo(
                targetValue = 1f,
                animationSpec = tween(2000)
            )
            delay(2000L)

            Intent(this@SplashActivity, MainActivity::class.java)
                .apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                }
                .also {
                    startActivity(it)
                    finish()
                }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Pink40),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val painter = painterResource(id = R.drawable.ic_launcher_foreground)

            Column(
                modifier = Modifier
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .alpha(alpha.value),
                    painter = painter,
                    contentScale = ContentScale.FillWidth,
                    contentDescription = "Splash",
                )
            }
        }
    }
}
