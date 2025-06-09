package br.com.nsbarros.android.compose.lojateniscompose.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.nsbarros.android.compose.lojateniscompose.ui.components.CategoryChips
import br.com.nsbarros.android.compose.lojateniscompose.ui.components.ProductGrid
import br.com.nsbarros.android.compose.lojateniscompose.ui.components.ProductSearchBar
import br.com.nsbarros.android.compose.lojateniscompose.ui.screen.home.state.HomeEvent
import br.com.nsbarros.android.compose.lojateniscompose.ui.screen.home.state.HomeState

@Composable
fun HomeScreen(
    state: HomeState,
    onEvent: (HomeEvent) -> Unit
) {
    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = null) },
                    selected = true,
                    onClick = {},
                    label = { Text("Home") }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.ShoppingCart, contentDescription = null) },
                    selected = false,
                    onClick = {},
                    label = { Text("Carrinho") }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = null) },
                    selected = false,
                    onClick = {},
                    label = { Text("Perfil") }
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(Color.White)
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "Olá, ${state.userName}",
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            ProductSearchBar(
                query = state.searchQuery,
                onQueryChanged = { onEvent(HomeEvent.OnSearchChanged(it)) }
            )

            Spacer(modifier = Modifier.height(16.dp))

            CategoryChips(
                categories = state.categories,
                selectedCategory = state.selectedCategory,
                onCategorySelected = { onEvent(HomeEvent.OnCategorySelected(it)) }
            )

            Spacer(modifier = Modifier.height(16.dp))

            ProductGrid(
                products = state.products,
                onProductClick = { onEvent(HomeEvent.OnProductClicked(it)) }
            )
        }
    }
}