package br.com.nsbarros.android.compose.lojateniscompose.domain.usecase


import br.com.nsbarros.android.compose.lojateniscompose.domain.model.Product
import br.com.nsbarros.android.compose.lojateniscompose.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow

class SearchProductsUseCase(
    private val repository: ProductRepository
) {
    operator fun invoke(query: String): Flow<List<Product>> = repository.searchProducts(query)
}