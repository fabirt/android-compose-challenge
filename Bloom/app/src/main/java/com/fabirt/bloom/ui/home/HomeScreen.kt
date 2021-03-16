package com.fabirt.bloom.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fabirt.bloom.domain.Screen

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
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavHost(navController, startDestination = Screen.Home.route) {
                composable(Screen.Home.route) { HomeContent() }
                composable(Screen.Favorites.route) { DummyContent(Screen.Favorites.route) }
                composable(Screen.Profile.route) { DummyContent(Screen.Profile.route) }
                composable(Screen.Cart.route) { DummyContent(Screen.Cart.route) }
            }
        }
    }
}
