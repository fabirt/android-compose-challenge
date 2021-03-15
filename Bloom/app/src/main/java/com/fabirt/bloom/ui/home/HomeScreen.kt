package com.fabirt.bloom.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.fabirt.bloom.ui.theme.BloomTheme
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun HomeScreen(
    navController: NavHostController? = null
) {
    Scaffold(
        backgroundColor = MaterialTheme.colors.background,
        bottomBar = {
            BottomNavigation(
                backgroundColor = MaterialTheme.colors.primary,
                elevation = 16.dp,
                modifier = Modifier.navigationBarsPadding()
            ) {
                BottomNavigationItem(
                    selected = true,
                    onClick = {},
                    icon = { Icon(Icons.Filled.Home, "") },
                    label = { Text("Home") }
                )
                BottomNavigationItem(
                    selected = false,
                    onClick = {},
                    icon = { Icon(Icons.Filled.Favorite, "") },
                    label = { Text("Favorites") }
                )
                BottomNavigationItem(
                    selected = false,
                    onClick = {},
                    icon = { Icon(Icons.Filled.Person, "") },
                    label = { Text("Profile") }
                )
                BottomNavigationItem(
                    selected = false,
                    onClick = {},
                    icon = { Icon(Icons.Filled.ShoppingCart, "") },
                    label = { Text("Cart") }
                )
            }
        }
    ) {
        Column(Modifier.statusBarsPadding()) {
            Text(text = "Home")
        }
    }
}

@Preview()
@Composable
fun HomeScreenPreview() {
    BloomTheme {
        ProvideWindowInsets {
            HomeScreen()
        }
    }
}