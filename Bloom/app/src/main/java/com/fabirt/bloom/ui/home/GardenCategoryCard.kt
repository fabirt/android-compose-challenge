package com.fabirt.bloom.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fabirt.bloom.data.demoCategories
import com.fabirt.bloom.domain.GardenCategory
import com.fabirt.bloom.ui.common.NetworkImage
import com.fabirt.bloom.ui.common.PreviewContent
import com.fabirt.bloom.ui.common.ripple

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
            .background(MaterialTheme.colors.surface)
            .ripple(MaterialTheme.colors.onBackground) { },
    ) {
        Column {
            NetworkImage(
                data = value.imageUrl ,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
            )
            Text(
                text = value.name,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                style = MaterialTheme.typography.h2.copy(
                    color = MaterialTheme.colors.onBackground
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
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