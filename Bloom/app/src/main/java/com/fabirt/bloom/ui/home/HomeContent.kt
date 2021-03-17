package com.fabirt.bloom.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fabirt.bloom.data.demoCategories
import com.fabirt.bloom.data.demoPlants
import com.fabirt.bloom.ui.common.PreviewContent
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.statusBarsPadding
import com.google.accompanist.insets.toPaddingValues

@Composable
fun HomeContent() {
    val commonModifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp)

    val headerTextStyle = MaterialTheme.typography.h1.copy(
        color = MaterialTheme.colors.onBackground
    )

    val imeiPadding = LocalWindowInsets.current.ime.toPaddingValues().calculateBottomPadding()
    val navPadding = LocalWindowInsets.current.navigationBars.toPaddingValues().calculateBottomPadding()
    val bottomPadding = if (imeiPadding > navPadding) {
        imeiPadding - navPadding
    } else 0.dp

    Scaffold {
        Column(
            Modifier
                .fillMaxSize()
                .statusBarsPadding()
        ) {
            Spacer(Modifier.height(24.dp))
            SearchField(modifier = commonModifier)
            Column(
                Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(vertical = 16.dp)
                    .padding(bottom = bottomPadding)
            ) {
                Text(text = "Browse themes", style = headerTextStyle, modifier = commonModifier)
                Spacer(Modifier.height(16.dp))
                GardenCategoryList(data = demoCategories)
                Spacer(Modifier.height(16.dp))
                Text(
                    text = "Design your home garden",
                    style = headerTextStyle,
                    modifier = commonModifier
                )
                Spacer(Modifier.height(16.dp))
                PlantListView(data = demoPlants, modifier = commonModifier)
            }
        }
    }
}

@Preview
@Composable
fun HomeContentPreview() {
    PreviewContent {
        HomeContent()
    }
}