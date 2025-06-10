package br.com.nsbarros.android.compose.lojateniscompose.ui.screen.productdetail.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.nsbarros.android.compose.lojateniscompose.domain.usecase.GetProductByIdUseCase
import br.com.nsbarros.android.compose.lojateniscompose.ui.screen.productdetail.event.ProductDetailEvent
import br.com.nsbarros.android.compose.lojateniscompose.ui.screen.productdetail.state.ProductDetailState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductDetailViewModel(
    private val productId: String,
    private val getProductByIdUseCase: GetProductByIdUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(ProductDetailState())
    val state: StateFlow<ProductDetailState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            getProductByIdUseCase(productId).collect { product ->
                _state.update { it.copy(product = product) }
            }
        }
    }

    fun onEvent(event: ProductDetailEvent) {
        when (event) {
            is ProductDetailEvent.ToggleFavorite -> {
                _state.update { currentState ->
                    val updatedProduct = currentState.product?.copy(
                        isFavorite = !(currentState.product?.isFavorite ?: false)
                    )
                    currentState.copy(product = updatedProduct)
                }
            }

            is ProductDetailEvent.AddToCart -> {
                _state.update {
                    it.copy(
                        showSnackbar = true,
                        snackbarMessage = "Produto adicionado com sucesso!"
                    )
                }
            }

            is ProductDetailEvent.SnackbarShown -> {
                _state.update {
                    it.copy(showSnackbar = false, snackbarMessage = "")
                }
            }
        }
    }
}