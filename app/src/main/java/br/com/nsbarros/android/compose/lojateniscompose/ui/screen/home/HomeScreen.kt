package br.com.nsbarros.android.compose.lojateniscompose.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.nsbarros.android.compose.lojateniscompose.ui.components.CategoryChips
import br.com.nsbarros.android.compose.lojateniscompose.ui.components.ProductGrid
import br.com.nsbarros.android.compose.lojateniscompose.ui.components.ProductSearchBar
import br.com.nsbarros.android.compose.lojateniscompose.ui.screen.home.event.HomeEvent
import br.com.nsbarros.android.compose.lojateniscompose.ui.screen.home.state.HomeState
import br.com.nsbarros.android.compose.lojateniscompose.ui.theme.Secondary

@Composable
fun HomeScreen(
    state: HomeState,
    onEvent: (HomeEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Olá, ${state.userName}",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier
                .padding(top = 8.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(8.dp))

        ProductSearchBar(
            query = state.searchQuery,
            onQueryChanged = { onEvent(HomeEvent.OnSearchChanged(it)) }
        )

        Spacer(modifier = Modifier.height(8.dp))

        CategoryChips(
            categories = state.categories,
            selectedCategory = state.selectedCategory,
            onCategorySelected = { onEvent(HomeEvent.OnCategorySelected(it)) }
        )

        Spacer(modifier = Modifier.height(8.dp))

        if (state.products.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 64.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Nada para exibir em \"${state.selectedCategory}\"",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Secondary
                )
            }
        } else {
            ProductGrid(
                products = state.products,
                onProductClick = { onEvent(HomeEvent.OnProductClicked(it)) }
            )
        }
    }
}
