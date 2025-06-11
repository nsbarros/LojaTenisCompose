package br.com.nsbarros.android.compose.lojateniscompose.data

import br.com.nsbarros.android.compose.lojateniscompose.domain.model.Product
import br.com.nsbarros.android.compose.lojateniscompose.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeProductRepository : ProductRepository {

    private val products = listOf(
        Product("1", "Produto 1", "link", 3.25, "Todos", "Teste Produto 1", 5.0, false),
        Product("2", "Produto 2", "link", 2.25, "Botas", "Teste Produto 2", 5.0, false),
        Product("3", "Produto 3", "link", 3.25, "Chuteiras", "Teste Produto 3", 5.0, false),
        Product("4", "Produto 4", "link", 4.25, "Todos", "Teste Produto 4", 5.0, false),
        Product("5", "Nike", "link", 5.25, "Nike", "Teste Produto Nike", 5.0, false),
        Product("6", "Nike", "link", 6.25, "Nike", "Teste Produto Nike 2", 5.0, false)

    )

    override fun getProducts(): Flow<List<Product>> = flowOf(products)

    override fun getProductsByCategory(category: String): Flow<List<Product>> = flowOf(products.filter { it.category.equals(category) })

    override fun searchProducts(query: String): Flow<List<Product>> = flowOf(products.filter { it.name.contains(query) })
}