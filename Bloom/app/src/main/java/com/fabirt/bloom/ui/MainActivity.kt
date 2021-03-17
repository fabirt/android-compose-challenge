package com.fabirt.bloom.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fabirt.bloom.R
import com.fabirt.bloom.navigation.Destinations
import com.fabirt.bloom.ui.home.HomeScreen
import com.fabirt.bloom.ui.login.LoginScreen
import com.fabirt.bloom.ui.theme.BloomTheme
import com.fabirt.bloom.ui.welcome.WelcomeScreen
import com.google.accompanist.insets.ExperimentalAnimatedInsets
import com.google.accompanist.insets.ProvideWindowInsets

class MainActivity : ComponentActivity() {
    @ExperimentalAnimatedInsets
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Bloom)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            BloomApp()
        }
    }
}

@ExperimentalAnimatedInsets
@ExperimentalComposeUiApi
@Composable
fun BloomApp() {
    val navController = rememberNavController()

    BloomTheme {
        ProvideWindowInsets(windowInsetsAnimationsEnabled = true) {
            NavHost(navController, startDestination = Destinations.welcome) {
                composable(Destinations.welcome) {
                    WelcomeScreen(navController)
                }
                composable(Destinations.login) {
                    LoginScreen(navController)
                }
                composable(Destinations.home) {
                    HomeScreen(navController)
                }
            }
        }
    }
}
