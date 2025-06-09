package br.com.nsbarros.android.compose.lojateniscompose.ui.screen.home.state

import br.com.nsbarros.android.compose.lojateniscompose.domain.model.Product

data class HomeState(
    val userName: String = "",
    val searchQuery: String = "",
    val selectedCategory: String = "Todos",
    val categories: List<String> = listOf("Todos", "Tênis", "Chuteiras", "Botas", "Sapatênis"),
    val products: List<Product> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)