package br.com.nsbarros.android.compose.lojateniscompose.di

import androidx.lifecycle.SavedStateHandle
import br.com.nsbarros.android.compose.lojateniscompose.data.repository.ProductRepositoryImpl
import br.com.nsbarros.android.compose.lojateniscompose.domain.repository.ProductRepository
import br.com.nsbarros.android.compose.lojateniscompose.domain.usecase.GetProductByIdUseCase
import br.com.nsbarros.android.compose.lojateniscompose.domain.usecase.GetProductsByCategoryUseCase
import br.com.nsbarros.android.compose.lojateniscompose.domain.usecase.GetProductsUseCase
import br.com.nsbarros.android.compose.lojateniscompose.domain.usecase.SearchProductsUseCase
import br.com.nsbarros.android.compose.lojateniscompose.ui.screen.home.viewmodel.HomeViewModel
import br.com.nsbarros.android.compose.lojateniscompose.ui.screen.productdetail.ProductDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    // Repositório
    single<ProductRepository> { ProductRepositoryImpl() }

    // UseCases
    single { GetProductsUseCase(get()) }
    single { GetProductsByCategoryUseCase(get()) }
    single { SearchProductsUseCase(get()) }
    single { GetProductByIdUseCase(get()) }

    // ViewModel
    viewModel {
        HomeViewModel(
            getProductsUseCase = get(),
            getProductsByCategoryUseCase = get(),
            searchProductsUseCase = get()
        )
    }

    // ViewModel da tela de detalhes (usa SavedStateHandle)
    viewModel { (savedStateHandle: SavedStateHandle) ->
        ProductDetailViewModel(
            getProductByIdUseCase = get(),
            savedStateHandle = savedStateHandle
        )
    }
}