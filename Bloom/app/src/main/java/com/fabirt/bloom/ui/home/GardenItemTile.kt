package com.fabirt.bloom.ui.home

import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fabirt.bloom.domain.GardenItem

@Composable
fun GardenItemTile(value: GardenItem) {
    Text(value.name, modifier = Modifier.height(64.dp))
}
