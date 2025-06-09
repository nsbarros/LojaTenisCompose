package br.com.nsbarros.android.compose.lojateniscompose.ui.screen.home

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.nsbarros.android.compose.lojateniscompose.domain.model.Product
import br.com.nsbarros.android.compose.lojateniscompose.ui.theme.LojaTenisComposeTheme
import br.com.nsbarros.android.compose.lojateniscompose.ui.screen.home.state.HomeState

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    val fakeState = HomeState(
        userName = "João",
        searchQuery = "",
        selectedCategory = "Todos",
        categories = listOf("Todos", "Tênis", "Chuteiras", "Botas", "Sapatênis"),
        products = listOf(
            Product(
                id = "1",
                name = "Tênis Air Max",
                imageUrl = "https://via.placeholder.com/150",
                price = 299.99,
                category = "Tênis",
                description = "Tênis confortável para o dia a dia.",
                rating = 4.5,
                isFavorite = true
            ),
            Product(
                id = "2",
                name = "Chuteira Pro Max",
                imageUrl = "https://via.placeholder.com/150",
                price = 199.99,
                category = "Chuteira",
                description = "Chuteira ideal para gramado seco.",
                rating = 4.8,
                isFavorite = false
            )
        )
    )

    LojaTenisComposeTheme {
        HomeScreen(
            state = fakeState,
            onEvent = {}
        )
    }
}