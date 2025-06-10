package br.com.nsbarros.android.compose.lojateniscompose.ui.screen.productdetail.state

import br.com.nsbarros.android.compose.lojateniscompose.domain.model.Product

data class ProductDetailState(
    val product: Product? = null,
    val showSnackbar: Boolean = false,
    val snackbarMessage: String = ""
)