package br.com.nsbarros.android.compose.lojateniscompose.ui.screen.productdetail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProductDetailRoute(
    onBack: () -> Unit,
    viewModel: ProductDetailViewModel = koinViewModel()
) {
    val product by viewModel.state.collectAsState()

    product?.let {
        ProductDetailScreen(
            product = it,
            onBack = onBack
        )
    }
}