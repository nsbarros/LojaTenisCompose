package br.com.nsbarros.android.compose.lojateniscompose.ui.components.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.nsbarros.android.compose.lojateniscompose.ui.components.ProductSearchBar
import br.com.nsbarros.android.compose.lojateniscompose.ui.theme.LojaTenisComposeTheme

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    LojaTenisComposeTheme {
        ProductSearchBar(
            query = "Buscar tênis...",
            onQueryChanged = {}
        )
    }
}