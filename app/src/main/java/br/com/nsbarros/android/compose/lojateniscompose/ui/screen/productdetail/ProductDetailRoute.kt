package br.com.nsbarros.android.compose.lojateniscompose.ui.screen.productdetail

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import br.com.nsbarros.android.compose.lojateniscompose.ui.screen.productdetail.event.ProductDetailEvent
import br.com.nsbarros.android.compose.lojateniscompose.ui.screen.productdetail.viewmodel.ProductDetailViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProductDetailRoute(
    productId: String,
    onBack: () -> Unit
) {
    val viewModel: ProductDetailViewModel = koinViewModel()
    val state by viewModel.state.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(state.showSnackbar) {
        if (state.showSnackbar) {
            snackbarHostState.showSnackbar(state.snackbarMessage)
            viewModel.onEvent(ProductDetailEvent.SnackbarShown)
        }
    }

    ProductDetailScreen(
        state = state,
        onEvent = viewModel::onEvent,
        onBack = onBack,
        snackbarHostState = snackbarHostState
    )
}