package com.fabirt.bloom.ui.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color

fun Modifier.ripple(
    color: Color,
    onClick: () -> Unit
) = composed {
    Modifier.clickable(
        enabled = true,
        onClickLabel = null,
        onClick = onClick,
        role = null,
        indication = rememberRipple(color = color),
        interactionSource = remember { MutableInteractionSource() }
    )
}

fun Modifier.center() = composed {
    Modifier
        .fillMaxSize()
        .wrapContentHeight()
        .wrapContentWidth()
}
