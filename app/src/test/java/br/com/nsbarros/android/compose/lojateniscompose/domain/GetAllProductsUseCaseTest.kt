
package br.com.nsbarros.android.compose.lojateniscompose.domain.usecase

import br.com.nsbarros.android.compose.lojateniscompose.data.FakeProductRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class GetAllProductsUseCaseTest {

    private lateinit var repository: FakeProductRepository
    private lateinit var useCase: GetProductsUseCase

    @Before
    fun setup() {
        repository = FakeProductRepository()
        useCase = GetProductsUseCase(repository)
    }

    @Test
    fun `deve retornar todos os produtos corretamente`() = runTest {
        val produtos = useCase()

        assertEquals("A lista de produtos deve conter 3 itens", 6, produtos.first().size)
    }
}
