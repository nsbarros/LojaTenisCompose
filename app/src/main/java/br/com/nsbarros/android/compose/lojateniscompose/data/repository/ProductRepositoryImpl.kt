package br.com.nsbarros.android.compose.lojateniscompose.data.repository

import br.com.nsbarros.android.compose.lojateniscompose.data.datasource.FakeProductDataSource
import br.com.nsbarros.android.compose.lojateniscompose.data.mapper.toDomain
import br.com.nsbarros.android.compose.lojateniscompose.domain.model.Product
import br.com.nsbarros.android.compose.lojateniscompose.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProductRepositoryImpl : ProductRepository {

    override fun getProducts(): Flow<List<Product>> = flow {
        val products = FakeProductDataSource.products.map { it.toDomain() }
        emit(products)
    }

    override fun getProductsByCategory(category: String): Flow<List<Product>> = flow {
        val products = FakeProductDataSource.products
            .filter { it.category.equals(category, ignoreCase = true) }
            .map { it.toDomain() }
        emit(products)
    }

    override fun searchProducts(query: String): Flow<List<Product>> = flow {
        val products = FakeProductDataSource.products
            .filter { it.name.contains(query, ignoreCase = true) }
            .map { it.toDomain() }
        emit(products)
    }
}