package com.fabirt.bloom.ui.common

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.toPaddingValues

fun Modifier.keyboardAware() = composed {
    val imeiPadding = LocalWindowInsets.current.ime.toPaddingValues().calculateBottomPadding()
    val navBarPadding =
        LocalWindowInsets.current.navigationBars.toPaddingValues().calculateBottomPadding()
    val bottomPadding = if (imeiPadding > navBarPadding) {
        imeiPadding - navBarPadding
    } else 0.dp

    padding(bottom = bottomPadding)
}

fun Modifier.keyboardAwareScroll(
    state: ScrollState
) = composed {
    verticalScroll(state).keyboardAware()
}
