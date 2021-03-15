package com.fabirt.bloom.domain

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.fabirt.bloom.R

sealed class Screen(
    val route: String,
    @StringRes val resourceId: Int,
    val icon: ImageVector
    ) {
    object Home : Screen("home", R.string.home, Icons.Filled.Home)
    object Favorites : Screen("favorites", R.string.favorites, Icons.Filled.Favorite)
    object Profile : Screen("profile", R.string.profile, Icons.Filled.Person)
    object Cart : Screen("cart", R.string.cart, Icons.Filled.ShoppingCart)
}
