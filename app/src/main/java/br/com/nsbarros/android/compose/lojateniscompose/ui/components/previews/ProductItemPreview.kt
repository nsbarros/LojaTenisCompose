package br.com.nsbarros.android.compose.lojateniscompose.ui.components.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.nsbarros.android.compose.lojateniscompose.domain.model.Product
import br.com.nsbarros.android.compose.lojateniscompose.ui.theme.LojaTenisComposeTheme
import br.com.nsbarros.android.compose.lojateniscompose.ui.components.ProductItem

@Preview(showBackground = true)
@Composable
fun ProductItemPreview() {
    LojaTenisComposeTheme {
        ProductItem(
            product = Product(
                id = "1",
                name = "Tênis Air Max",
                imageUrl = "https://via.placeholder.com/150",
                price = 299.99,
                category = "Tênis",
                description = "Tênis confortável para o dia a dia.",
                rating = 4.5,
                isFavorite = true
            ),
            onClick = {}
        )
    }
}