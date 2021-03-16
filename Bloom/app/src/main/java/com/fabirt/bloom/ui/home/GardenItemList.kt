package com.fabirt.bloom.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fabirt.bloom.domain.GardenItem

@Composable
fun GardenItemList(data: List<GardenItem>, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        data.forEach {
            GardenItemTile(value = it)
        }
    }
}
