package br.com.nsbarros.android.compose.lojateniscompose.domain.usecase

import br.com.nsbarros.android.compose.lojateniscompose.domain.model.Product
import br.com.nsbarros.android.compose.lojateniscompose.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetProductByIdUseCase(
    private val repository: ProductRepository
) {
    operator fun invoke(id: String): Flow<Product?> {
        return repository.getProducts().map { list ->
            list.firstOrNull { it.id == id }
        }
    }
}