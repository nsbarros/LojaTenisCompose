package br.com.nsbarros.android.compose.lojateniscompose.ui.theme.home.state

import br.com.nsbarros.android.compose.lojateniscompose.domain.model.Product

sealed class HomeEvent {
    data object LoadData : HomeEvent()
    data class OnSearchChanged(val query: String) : HomeEvent()
    data class OnCategorySelected(val category: String) : HomeEvent()
    data class OnProductClicked(val product: Product) : HomeEvent()
}