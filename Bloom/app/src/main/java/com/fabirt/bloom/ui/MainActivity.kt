package com.fabirt.bloom.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.fabirt.bloom.ui.theme.BloomTheme
import com.fabirt.bloom.ui.welcome.WelcomeScreen
import com.google.accompanist.insets.ProvideWindowInsets

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            BloomTheme {
                ProvideWindowInsets {
                    WelcomeScreen()
                }
            }
        }
    }
}
