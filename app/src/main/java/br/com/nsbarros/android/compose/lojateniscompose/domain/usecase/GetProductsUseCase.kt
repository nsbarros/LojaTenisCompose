package br.com.nsbarros.android.compose.lojateniscompose.domain.usecase

import br.com.nsbarros.android.compose.lojateniscompose.domain.model.Product
import br.com.nsbarros.android.compose.lojateniscompose.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow

class GetProductsUseCase(
    private val respository: ProductRepository
) {
    operator fun invoke(): Flow<List<Product>> = respository.getProducts()
}