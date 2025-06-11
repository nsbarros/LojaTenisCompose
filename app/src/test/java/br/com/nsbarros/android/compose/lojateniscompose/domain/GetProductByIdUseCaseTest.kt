package br.com.nsbarros.android.compose.lojateniscompose.domain

import br.com.nsbarros.android.compose.lojateniscompose.data.FakeProductRepository
import br.com.nsbarros.android.compose.lojateniscompose.domain.repository.ProductRepository
import br.com.nsbarros.android.compose.lojateniscompose.domain.usecase.GetProductByIdUseCase
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class GetProductByIdUseCaseTest {

    private lateinit var repository: ProductRepository
    private lateinit var useCase: GetProductByIdUseCase

    @Before
    fun setup() {
        repository = FakeProductRepository()
        useCase = GetProductByIdUseCase(repository)
    }

    @Test
    fun `quando o ID do produto for válido, deve retornar o produto correspondente`() = runTest {
        val resultado = useCase("1").first()

        assertNotNull(resultado)
        assertEquals("Produto 1", resultado?.name)
    }

    @Test
    fun `quando o ID do produto for inválido, deve retornar null`() = runTest {
        val resultado = useCase("999").first()

        assertNull(resultado)
    }
}