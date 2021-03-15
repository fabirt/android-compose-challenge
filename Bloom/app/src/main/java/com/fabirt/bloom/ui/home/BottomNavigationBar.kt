package com.fabirt.bloom.ui.home

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.KEY_ROUTE
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigate
import com.fabirt.bloom.domain.Screen
import com.google.accompanist.insets.navigationBarsPadding

@Composable
fun BottomNavigationBar(
    items: List<Screen>,
    navController: NavHostController
) {
    val color = MaterialTheme.colors.primary

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)

    val changeScreen = { screen: Screen ->
        navController.navigate(screen.route) {
            popUpTo = navController.graph.startDestination
            launchSingleTop = true
        }
    }

    Surface(
        elevation = 16.dp,
        color = color
    ) {
        BottomNavigation(
            backgroundColor = color,
            elevation = 0.dp,
            modifier = Modifier.navigationBarsPadding(),
        ) {
            items.forEach { screen ->
                BottomNavigationItem(
                    selected = currentRoute == screen.route,
                    onClick = { changeScreen(screen) },
                    icon = { Icon(screen.icon, screen.route) },
                    label = { Text(stringResource(screen.resourceId)) }
                )
            }
        }
    }
}