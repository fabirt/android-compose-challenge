package com.fabirt.bloom.ui.common

import androidx.compose.runtime.Composable
import com.fabirt.bloom.ui.theme.BloomTheme
import com.google.accompanist.insets.ProvideWindowInsets

@Composable
fun PreviewContent(content: @Composable () -> Unit) {
    BloomTheme {
        ProvideWindowInsets {
            content()
        }
    }
}
