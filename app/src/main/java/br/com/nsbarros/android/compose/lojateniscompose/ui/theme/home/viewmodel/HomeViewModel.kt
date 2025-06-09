package br.com.nsbarros.android.compose.lojateniscompose.ui.theme.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.nsbarros.android.compose.lojateniscompose.domain.usecase.GetProductsByCategoryUseCase
import br.com.nsbarros.android.compose.lojateniscompose.domain.usecase.GetProductsUseCase
import br.com.nsbarros.android.compose.lojateniscompose.domain.usecase.SearchProductsUseCase
import br.com.nsbarros.android.compose.lojateniscompose.ui.theme.home.state.HomeEffect
import br.com.nsbarros.android.compose.lojateniscompose.ui.theme.home.state.HomeEvent
import br.com.nsbarros.android.compose.lojateniscompose.ui.theme.home.state.HomeState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getProductsUseCase: GetProductsUseCase,
    private val getProductsByCategoryUseCase: GetProductsByCategoryUseCase,
    private val searchProductsUseCase: SearchProductsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state.asStateFlow()

    private val _effect = MutableSharedFlow<HomeEffect>()
    val effect: SharedFlow<HomeEffect> = _effect.asSharedFlow()

    init {
        onEvent(HomeEvent.LoadData)
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.LoadData -> loadAllProducts()
            is HomeEvent.OnSearchChanged -> {
                _state.update { it.copy(searchQuery = event.query) }
                searchProducts(event.query)
            }
            is HomeEvent.OnCategorySelected -> {
                _state.update { it.copy(selectedCategory = event.category) }
                filterByCategory(event.category)
            }
            is HomeEvent.OnProductClicked -> {
                viewModelScope.launch {
                    _effect.emit(HomeEffect.NavigateToProductDetail(event.product.id))
                }
            }
        }
    }

    private fun loadAllProducts() {
        viewModelScope.launch {
            getProductsUseCase()
                .onStart { _state.update { it.copy(isLoading = true) } }
                .catch { error -> _state.update { it.copy(error = error.message, isLoading = false) } }
                .collect { products ->
                    _state.update {
                        it.copy(
                            products = products,
                            isLoading = false,
                            error = null
                        )
                    }
                }
        }
    }

    private fun searchProducts(query: String) {
        viewModelScope.launch {
            searchProductsUseCase(query)
                .catch { error -> _state.update { it.copy(error = error.message) } }
                .collect { products ->
                    _state.update { it.copy(products = products, error = null) }
                }
        }
    }

    private fun filterByCategory(category: String) {
        viewModelScope.launch {
            if (category == "Todos") {
                loadAllProducts()
            } else {
                getProductsByCategoryUseCase(category)
                    .catch { error -> _state.update { it.copy(error = error.message) } }
                    .collect { products ->
                        _state.update { it.copy(products = products, error = null) }
                    }
            }
        }
    }
}