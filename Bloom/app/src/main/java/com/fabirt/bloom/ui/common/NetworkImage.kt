package com.fabirt.bloom.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import dev.chrisbanes.accompanist.coil.CoilImage
import dev.chrisbanes.accompanist.glide.GlideImage

@Composable
fun NetworkImage(
    data: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop,
    fadeIn: Boolean = true,
) {
    CoilImage(
        data = data,
        modifier = modifier,
        contentDescription = "My content description",
        fadeIn = fadeIn,
        contentScale = contentScale,
        loading = {
            Box(
                Modifier
                    .background(MaterialTheme.colors.surface)
                    .matchParentSize()) {
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            }
        },
        error = {
            Text("Error", Modifier.align(Alignment.Center))
        },
    )
}