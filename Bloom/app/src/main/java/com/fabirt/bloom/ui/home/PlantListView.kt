package com.fabirt.bloom.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fabirt.bloom.domain.Plant

@Composable
fun PlantListView(data: List<Plant>, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        data.forEach {
            PlantListTile(value = it)
        }
    }
}
