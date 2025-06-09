package br.com.nsbarros.android.compose.lojateniscompose.ui.components.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.nsbarros.android.compose.lojateniscompose.domain.model.Product
import br.com.nsbarros.android.compose.lojateniscompose.ui.components.ProductGrid

@Preview(showBackground = true)
@Composable
fun ProductGridPreview() {
    val mockProducts = listOf(
        Product(
            id = "1",
            name = "Nike Air Max 2013",
            price = 920.99,
            imageUrl = "https://imgnike-a.akamaihd.net/airmax2013.jpg",
            description = "Tênis confortável e moderno",
            rating = 4.5,
            isFavorite = false,
            category = "Todos"
        ),
        Product(
            id = "2",
            name = "Nike Air Zoom Upturn",
            price = 399.99,
            imageUrl = "https://imgnike-a.akamaihd.net/airzoomupturn.jpg",
            description = "Design esportivo para o dia a dia",
            rating = 4.2,
            isFavorite = true,
            category = "Todos"
        )
    )

    ProductGrid(
        products = mockProducts,
        onProductClick = {}
    )
}