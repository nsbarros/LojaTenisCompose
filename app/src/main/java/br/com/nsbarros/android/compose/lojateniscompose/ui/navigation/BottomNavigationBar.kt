package br.com.nsbarros.android.compose.lojateniscompose.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import br.com.nsbarros.android.compose.lojateniscompose.ui.theme.BackgroundLight
import br.com.nsbarros.android.compose.lojateniscompose.ui.theme.Primary
import br.com.nsbarros.android.compose.lojateniscompose.ui.theme.Secondary

@Composable
fun BottomNavigationBar(
    currentRoute: String,
    onNavigate: (String) -> Unit
) {
    NavigationBar(containerColor = BackgroundLight) {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            selected = currentRoute == "home",
            onClick = { onNavigate("home") },
            label = { Text("Home") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Primary,
                selectedTextColor = Primary,
                unselectedIconColor = Secondary,
                unselectedTextColor = Secondary,
                indicatorColor = BackgroundLight
            )
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Carrinho") },
            selected = currentRoute == "cart",
            onClick = { onNavigate("cart") },
            label = { Text("Carrinho") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Primary,
                selectedTextColor = Primary,
                unselectedIconColor = Secondary,
                unselectedTextColor = Secondary,
                indicatorColor = BackgroundLight
            )
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Person, contentDescription = "Perfil") },
            selected = currentRoute == "profile",
            onClick = { onNavigate("profile") },
            label = { Text("Perfil") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Primary,
                selectedTextColor = Primary,
                unselectedIconColor = Secondary,
                unselectedTextColor = Secondary,
                indicatorColor = BackgroundLight
            )
        )
    }
}