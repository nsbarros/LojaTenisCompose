package br.com.nsbarros.android.compose.lojateniscompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.nsbarros.android.compose.lojateniscompose.ui.screen.home.HomeScreen
import br.com.nsbarros.android.compose.lojateniscompose.ui.screen.home.state.HomeEffect
import br.com.nsbarros.android.compose.lojateniscompose.ui.screen.home.viewmodel.HomeViewModel
import br.com.nsbarros.android.compose.lojateniscompose.ui.screen.productdetail.ProductDetailRoute

@Composable
fun AppNavHost(viewModel: HomeViewModel) {
    val navController = rememberNavController()

    // Escuta os efeitos emitidos pela HomeViewModel
    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is HomeEffect.NavigateToProductDetail -> {
                    navController.navigate("productDetail/${effect.productId}")
                }
                else -> Unit
            }
        }
    }

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            val state by viewModel.state.collectAsState()
            HomeScreen(
                state = state,
                onEvent = viewModel::onEvent
            )
        }


        composable(
            route = "productDetail/{productId}",
            arguments = listOf(navArgument("productId") { type = NavType.StringType })
        ) {

            ProductDetailRoute(
                onBack = { navController.popBackStack() }
            )
        }
    }
}