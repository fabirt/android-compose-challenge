package com.fabirt.bloom.ui.home

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fabirt.bloom.domain.Screen
import com.fabirt.bloom.ui.theme.BloomTheme
import com.google.accompanist.insets.ProvideWindowInsets

@Composable
fun HomeScreen(
    rootNavHostController: NavHostController? = null
) {
    val screens = listOf(
        Screen.Home,
        Screen.Favorites,
        Screen.Profile,
        Screen.Cart,
    )

    val navController = rememberNavController()

    Scaffold(
        backgroundColor = MaterialTheme.colors.background,
        bottomBar = {
            BottomNavigationBar(
                items = screens,
                navController = navController
            )
        }
    ) {
        NavHost(navController, startDestination = Screen.Home.route) {
            composable(Screen.Home.route) { DummyContent(Screen.Home.route) }
            composable(Screen.Favorites.route) { DummyContent(Screen.Favorites.route) }
            composable(Screen.Profile.route) { DummyContent(Screen.Profile.route) }
            composable(Screen.Cart.route) { DummyContent(Screen.Cart.route) }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    BloomTheme {
        ProvideWindowInsets {
            HomeScreen()
        }
    }
}