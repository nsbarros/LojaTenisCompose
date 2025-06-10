package br.com.nsbarros.android.compose.lojateniscompose.ui.screen.productdetail

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import br.com.nsbarros.android.compose.lojateniscompose.domain.model.Product
import br.com.nsbarros.android.compose.lojateniscompose.ui.screen.productdetail.state.ProductDetailState

@Preview(showBackground = true)
@Composable
fun ProductDetailScreenPreview() {
    val fakeProduct = Product(
        id = "1",
        name = "Tênis de Teste",
        description = "Produto usado apenas no Preview",
        price = 199.99,
        imageUrl = "https://picsum.photos/200",
        rating = 4.5,
        isFavorite = false,
        category = "Todos"
    )

    val fakeState = ProductDetailState(
        product = fakeProduct,
        showSnackbar = false
    )

    ProductDetailScreen(
        state = fakeState,
        onEvent = {},
        onBack = {},
        snackbarHostState = remember { SnackbarHostState() }
    )
}