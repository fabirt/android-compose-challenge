package com.fabirt.bloom.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
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
    onClick: () -> Unit
) {
    val modifier = if (backgroundColor != null) {
        Modifier
            .padding(horizontal = 16.dp)
            .clip(MaterialTheme.shapes.large)
            .clickable(onClick = onClick)
            .background(color = backgroundColor)
            .height(48.dp)
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    } else {
        Modifier
            .padding(horizontal = 16.dp)
            .clip(MaterialTheme.shapes.large)
            .clickable(onClick = onClick)
            .height(48.dp)
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    }

    Text(
        text = text,
        style = MaterialTheme.typography.button.copy(color = textColor),
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}