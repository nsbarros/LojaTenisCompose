package br.com.nsbarros.android.compose.lojateniscompose.ui.theme.home.state

sealed class HomeEffect {
    data class NavigateToProductDetail(val productId: String) : HomeEffect()
    data class ShowError(val message: String) : HomeEffect()
}