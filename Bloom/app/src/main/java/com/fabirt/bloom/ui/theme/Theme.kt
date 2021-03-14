package com.fabirt.bloom.ui.theme

import androidx.annotation.DrawableRes
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.fabirt.bloom.R

private val DarkColorPalette = darkColors(
    primary = Green900,
    secondary = Green300,
    background = Gray,
    surface = White150,
    onPrimary = White,
    onSecondary = Gray,
    onBackground = White,
    onSurface = White850,
)

private val LightColorPalette = lightColors(
    primary = Pink100,
    secondary = Pink900,
    background = White,
    surface = White850,
    onPrimary = Gray,
    onSecondary = White,
    onBackground = Gray,
    onSurface = Gray,
)

private val LightThemeData = BloomThemeData(
    welcomeBg = R.drawable.ic_light_welcome_bg,
    welcomeIllos = R.drawable.ic_light_welcome_illos,
    welcomeIllosColor = Green900,
    logo = R.drawable.ic_light_logo,
)

private val DarkThemeData = BloomThemeData(
    welcomeBg = R.drawable.ic_dark_welcome_bg,
    welcomeIllos = R.drawable.ic_dark_welcome_illos,
    welcomeIllosColor = Pink100,
    logo = R.drawable.ic_dark_logo
)

@Composable
fun BloomTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val icons = if (darkTheme) {
        DarkThemeData
    } else {
        LightThemeData
    }

    ProvideBloomThemeData(icons = icons) {
        MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}

object BloomTheme {
    val data: BloomThemeData
        @Composable
        get() = LocalBloomThemeData.current
}

@Stable
class BloomThemeData(
    @DrawableRes
    var welcomeBg: Int,
    @DrawableRes
    var welcomeIllos: Int,
    var welcomeIllosColor: Color,
    @DrawableRes
    var logo: Int,
) {
    fun update(other: BloomThemeData) {
        welcomeBg = other.welcomeBg
        welcomeIllos = other.welcomeIllos
        logo = other.logo
        welcomeIllosColor = other.welcomeIllosColor
    }

}

@Composable
fun ProvideBloomThemeData(
    icons: BloomThemeData,
    content: @Composable () -> Unit
) {
    val data = remember { icons }
    data.update(icons)
    CompositionLocalProvider(LocalBloomThemeData provides data, content = content)
}

private val LocalBloomThemeData = staticCompositionLocalOf<BloomThemeData> {
    error("No BloomThemeData provided")
}