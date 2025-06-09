package br.com.nsbarros.android.compose.lojateniscompose.ui.theme.home.components.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.nsbarros.android.compose.lojateniscompose.ui.theme.LojaTenisComposeTheme
import br.com.nsbarros.android.compose.lojateniscompose.ui.theme.home.components.CategoryChips

@Preview(showBackground = true)
@Composable
fun CategoryChipsPreview() {
    LojaTenisComposeTheme {
        CategoryChips(
            categories = listOf("Todos", "Tênis", "Chuteiras", "Botas", "Sapatênis"),
            selectedCategory = "Tênis",
            onCategorySelected = {}
        )
    }
}