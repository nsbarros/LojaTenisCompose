package br.com.nsbarros.android.compose.lojateniscompose.domain.usecase

import br.com.nsbarros.android.compose.lojateniscompose.domain.model.Product
import br.com.nsbarros.android.compose.lojateniscompose.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow

class GetProductsByCategoryUseCase(
    private val repository: ProductRepository
) {
    operator fun invoke(category: String): Flow<List<Product>> = repository.getProductsByCategory(category)
}