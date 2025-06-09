package br.com.nsbarros.android.compose.lojateniscompose.ui.theme.home.components.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.nsbarros.android.compose.lojateniscompose.ui.theme.LojaTenisComposeTheme
import br.com.nsbarros.android.compose.lojateniscompose.ui.theme.home.components.SearchBar

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    LojaTenisComposeTheme {
        SearchBar(
            query = "Buscar tênis...",
            onQueryChanged = {}
        )
    }
}