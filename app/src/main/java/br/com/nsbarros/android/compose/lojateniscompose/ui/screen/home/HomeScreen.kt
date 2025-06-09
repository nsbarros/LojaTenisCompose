package br.com.nsbarros.android.compose.lojateniscompose.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.nsbarros.android.compose.lojateniscompose.domain.model.Product
import br.com.nsbarros.android.compose.lojateniscompose.ui.components.CategoryChips
import br.com.nsbarros.android.compose.lojateniscompose.ui.components.ProductItem
import br.com.nsbarros.android.compose.lojateniscompose.ui.components.SearchBar
import br.com.nsbarros.android.compose.lojateniscompose.ui.screen.home.state.HomeEvent
import br.com.nsbarros.android.compose.lojateniscompose.ui.screen.home.state.HomeState

@Composable
fun HomeScreen(
    state: HomeState,
    onEvent: (HomeEvent) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {

        Text(
            text = "Olá, ${state.userName}",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(16.dp)
        )

        SearchBar(
            query = state.searchQuery,
            onQueryChanged = { onEvent(HomeEvent.OnSearchChanged(it)) }
        )

        CategoryChips(
            categories = state.categories,
            selectedCategory = state.selectedCategory,
            onCategorySelected = { onEvent(HomeEvent.OnCategorySelected(it)) }
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 8.dp)
        ) {
            items(state.products) { product: Product ->
                ProductItem(
                    product = product,
                    onClick = { onEvent(HomeEvent.OnProductClicked(product)) }
                )
            }
        }
    }
}