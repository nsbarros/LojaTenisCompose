package br.com.nsbarros.android.compose.lojateniscompose.ui.screen.productdetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.nsbarros.android.compose.lojateniscompose.domain.model.Product
import br.com.nsbarros.android.compose.lojateniscompose.domain.usecase.GetProductByIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductDetailViewModel(
    private val getProductByIdUseCase: GetProductByIdUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableStateFlow<Product?>(null)
    val state: StateFlow<Product?> = _state

    init {
        val productId = savedStateHandle.get<String>("productId")

        if (productId != null) {
            viewModelScope.launch {
                getProductByIdUseCase(productId).collect {
                    _state.value = it
                }
            }
        }
    }
}