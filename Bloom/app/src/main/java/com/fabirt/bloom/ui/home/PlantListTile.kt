package com.fabirt.bloom.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fabirt.bloom.data.demoPlants
import com.fabirt.bloom.domain.Plant
import com.fabirt.bloom.ui.common.*

@Composable
fun PlantListTile(value: Plant) {
    var checked by rememberSaveable { mutableStateOf(false) }

    val toggle = { it: Boolean ->
        checked = it
    }

    Row(modifier = Modifier
        .padding(bottom = 8.dp)
        .height(64.dp)
        .ripple(null) {
            toggle(!checked)
        }
    ) {
        NetworkImage(
            data = value.picture,
            modifier = Modifier
                .padding(end = 8.dp)
                .size(64.dp)
                .clip(MaterialTheme.shapes.small)
        )
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .border(bottom = Border(color = MaterialTheme.colors.onBackground.copy(alpha = 0.1f))),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                Modifier
                    .weight(1f)
                    .offset(y = (-8).dp)) {
                Text(value.name, style = MaterialTheme.typography.h2)

                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(value.description, style = MaterialTheme.typography.body1)
                }
            }

            Checkbox(
                checked = checked,
                modifier = Modifier.offset(y = (-8).dp),
                onCheckedChange = toggle,
                colors = CheckboxDefaults.colors(
                    checkmarkColor = MaterialTheme.colors.background
                )
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun PlantListTilePreview() {
    PreviewContent {
        PlantListTile(value = demoPlants.first())
    }
}