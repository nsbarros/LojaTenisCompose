package br.com.nsbarros.android.compose.lojateniscompose.ui.screen.productdetail

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.nsbarros.android.compose.lojateniscompose.domain.model.Product

@Preview(showBackground = true)
@Composable
fun ProductDetailPreview() {
    val fakeProduct = Product(
        id = "1",
        name = "Tênis Esportivo",
        price = 299.99,
        imageUrl = "https://via.placeholder.com/300",
        category = "Esportes",
        description = "Tênis confortável, leve e com excelente amortecimento para atividades físicas.",
        rating = 4.7,
        isFavorite = false
    )

    ProductDetailScreen(
        product = fakeProduct,
        onBack = {}
    )
}