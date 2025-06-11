
package br.com.nsbarros.android.compose.lojateniscompose.domain.usecase

import br.com.nsbarros.android.compose.lojateniscompose.data.FakeProductRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class FilterProductsBySearchUseCaseTest {

    private lateinit var repository: FakeProductRepository
    private lateinit var useCase: SearchProductsUseCase

    @Before
    fun setup() {
        repository = FakeProductRepository()
        useCase = SearchProductsUseCase(repository)
    }

    @Test
    fun `deve retornar produtos cujo nome contenha a palavra pesquisada`() = runTest {
        val termoPesquisa = "Nike"
        val produtos = useCase(termoPesquisa)

        assertEquals("Deve retornar 2 produtos contendo 'Nike' no nome", 2, produtos.first().size)
    }
}
