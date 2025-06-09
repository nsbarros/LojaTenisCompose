package br.com.nsbarros.android.compose.lojateniscompose.domain.repository

import br.com.nsbarros.android.compose.lojateniscompose.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun getProducts(): Flow<List<Product>>
    fun getProductsByCategory(category: String): Flow<List<Product>>
    fun searchProducts(query: String): Flow<List<Product>>
}