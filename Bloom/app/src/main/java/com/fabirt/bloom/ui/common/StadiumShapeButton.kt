package com.fabirt.bloom.ui.common

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun StadiumShapeButton(
    text: String,
    textColor: Color,
    backgroundColor: Color? = null,
    isLoading: Boolean = false,
    onClick: () -> Unit,
    ) {
    var m = Modifier
        .padding(horizontal = 16.dp)
        .clip(MaterialTheme.shapes.large)
        .ripple(onClick = onClick, color = textColor)
        .animateContentSize()

    if (backgroundColor != null) {
        m = m.background(color = backgroundColor)
    }

    m = m.height(48.dp)

    m = if (isLoading) {
        m.width(48.dp).padding(8.dp).wrapContentSize(Alignment.Center)
    } else {
        m.fillMaxWidth().wrapContentSize(Alignment.Center)
    }

    Box(m) {
        if (isLoading)
            CircularProgressIndicator(
                color = MaterialTheme.colors.onSecondary,
                strokeWidth = 3.dp
            )
        else Text(
            text = text,
            style = MaterialTheme.typography.button.copy(color = textColor),
            textAlign = TextAlign.Center,
        )
    }
}
