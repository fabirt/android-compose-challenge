package com.fabirt.bloom.ui.home

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fabirt.bloom.ui.common.center
import com.google.accompanist.insets.systemBarsPadding

@Composable
fun DummyContent(
    text: String
) {
    Text(
        text,
        modifier = Modifier.systemBarsPadding().center()
    )
}