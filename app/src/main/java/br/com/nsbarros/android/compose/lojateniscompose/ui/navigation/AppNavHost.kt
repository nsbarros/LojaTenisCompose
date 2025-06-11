package br.com.nsbarros.android.compose.lojateniscompose.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.nsbarros.android.compose.lojateniscompose.ui.screen.cart.CartScreen
import br.com.nsbarros.android.compose.lojateniscompose.ui.screen.home.HomeScreen
import br.com.nsbarros.android.compose.lojateniscompose.ui.screen.home.effect.HomeEffect
import br.com.nsbarros.android.compose.lojateniscompose.ui.screen.home.viewmodel.HomeViewModel
import br.com.nsbarros.android.compose.lojateniscompose.ui.screen.productdetail.ProductDetailScreen
import br.com.nsbarros.android.compose.lojateniscompose.ui.screen.productdetail.event.ProductDetailEvent
import br.com.nsbarros.android.compose.lojateniscompose.ui.screen.productdetail.viewmodel.ProductDetailViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf


@Composable
fun AppNavHost(viewModel: HomeViewModel) {
    val navController = rememberNavController()
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is HomeEffect.NavigateToProductDetail -> {
                    navController.navigate("product_detail/${effect.productId}")
                }
                else -> Unit
            }
        }
    }

    Scaffold(
        bottomBar = {
            if (currentRoute in listOf("home", "cart", "profile")) {
                BottomNavigationBar(
                    currentRoute = currentRoute ?: "home",
                    onNavigate = { route ->
                        navController.navigate(route) {
                            popUpTo("home") { inclusive = false }
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("home") {
                val state by viewModel.state.collectAsState()
                HomeScreen(
                    state = state,
                    onEvent = viewModel::onEvent
                )
            }

            composable("cart") {
                CartScreen()
            }

            composable(
                route = "product_detail/{productId}",
                arguments = listOf(navArgument("productId") { type = NavType.StringType })
            ) { backStackEntry ->
                val productId = backStackEntry.arguments?.getString("productId") ?: return@composable
                val viewModel: ProductDetailViewModel = koinViewModel(
                    parameters = { parametersOf(productId) }
                )
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
                    onBack = { navController.popBackStack() },
                    snackbarHostState = snackbarHostState
                )
            }
        }
    }
}
