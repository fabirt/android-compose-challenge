package com.fabirt.bloom.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fabirt.bloom.data.demoCategories
import com.fabirt.bloom.domain.GardenCategory
import com.fabirt.bloom.ui.common.PreviewContent
import dev.chrisbanes.accompanist.glide.GlideImage

@Composable
fun GardenCategoryCard(
    value: GardenCategory
) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .shadow(elevation = 2.dp, shape = MaterialTheme.shapes.small)
            .size(136.dp)
            .clip(MaterialTheme.shapes.small)
            .background(MaterialTheme.colors.background)
            .clickable { },
    ) {
        Column {
            GlideImage(
                data = value.imageUrl,
                contentDescription = "My content description",
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                fadeIn = true,
                contentScale = ContentScale.Crop,
                loading = {
                    Box(Modifier.matchParentSize()) {
                        CircularProgressIndicator(Modifier.align(Alignment.Center))
                    }
                },
                error = {
                    Text("Error")
                },
            )
            Text(
                text = value.name,
                style = MaterialTheme.typography.h2.copy(
                    color = MaterialTheme.colors.onBackground
                ),
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
            )

        }
    }
}

@Preview(widthDp = 136, heightDp = 136)
@Composable
fun GardenCategoryCardPreview() {
    PreviewContent {
        GardenCategoryCard(
            value = demoCategories.first()
        )
    }
}