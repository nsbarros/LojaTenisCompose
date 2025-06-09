package br.com.nsbarros.android.compose.lojateniscompose.di

import br.com.nsbarros.android.compose.lojateniscompose.data.repository.ProductRepositoryImpl
import br.com.nsbarros.android.compose.lojateniscompose.domain.repository.ProductRepository
import br.com.nsbarros.android.compose.lojateniscompose.domain.usecase.GetProductsByCategoryUseCase
import br.com.nsbarros.android.compose.lojateniscompose.domain.usecase.GetProductsUseCase
import br.com.nsbarros.android.compose.lojateniscompose.domain.usecase.SearchProductsUseCase
import br.com.nsbarros.android.compose.lojateniscompose.ui.theme.home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    // Repositório
    single<ProductRepository> { ProductRepositoryImpl() }

    // UseCases
    single { GetProductsUseCase(get()) }
    single { GetProductsByCategoryUseCase(get()) }
    single { SearchProductsUseCase(get()) }

    // ViewModel
    viewModel {
        HomeViewModel(
            getProductsUseCase = get(),
            getProductsByCategoryUseCase = get(),
            searchProductsUseCase = get()
        )
    }
}