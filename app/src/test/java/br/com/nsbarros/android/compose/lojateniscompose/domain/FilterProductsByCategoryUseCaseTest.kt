
package br.com.nsbarros.android.compose.lojateniscompose.domain.usecase

import br.com.nsbarros.android.compose.lojateniscompose.data.FakeProductRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class FilterProductsByCategoryUseCaseTest {

    private lateinit var repository: FakeProductRepository
    private lateinit var useCase: GetProductsByCategoryUseCase

    @Before
    fun setup() {
        repository = FakeProductRepository()
        useCase = GetProductsByCategoryUseCase(repository)
    }

    @Test
    fun `deve retornar produtos da categoria especificada`() = runTest {
        val categoria = "Todos"
        val produtos = useCase(categoria)

        assertEquals("Deve retornar 2 produtos da categoria Corrida", 2, produtos.first().size)
    }
}
