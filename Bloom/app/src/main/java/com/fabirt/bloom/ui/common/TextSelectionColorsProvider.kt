package com.fabirt.bloom.ui.common

import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember

@Composable
fun TextSelectionColorsProvider(
    colors: Colors,
    content: @Composable () -> Unit
) {
    // Modifies text selection colors (by default it will take the primary color from MaterialTheme)
    val selectionColors = rememberTextSelectionColors(colors)

    CompositionLocalProvider(
        LocalTextSelectionColors provides selectionColors,
        content = content
    )
}

@Composable
private fun rememberTextSelectionColors(colors: Colors): TextSelectionColors {
    val primaryColor = colors.primary

    return remember(primaryColor) {
        TextSelectionColors(
            handleColor = primaryColor,
            backgroundColor = primaryColor.copy(alpha = 0.16f),
        )
    }
}