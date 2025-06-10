package br.com.nsbarros.android.compose.lojateniscompose.ui.screen.productdetail.event

sealed class ProductDetailEvent {
    object ToggleFavorite : ProductDetailEvent()
    object AddToCart : ProductDetailEvent()
    object SnackbarShown : ProductDetailEvent()
}