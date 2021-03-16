package com.fabirt.bloom.ui.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.fabirt.bloom.domain.GardenCategory

@Composable
fun GardenCategoryList(data: List<GardenCategory>) {
    LazyRow(contentPadding = PaddingValues(12.dp, 0.dp)) {
        items(data) { value ->
            GardenCategoryCard(value = value)
        }
    }
}
