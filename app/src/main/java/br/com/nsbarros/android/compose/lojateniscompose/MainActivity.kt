package br.com.nsbarros.android.compose.lojateniscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import br.com.nsbarros.android.compose.lojateniscompose.ui.navigation.AppNavHost
import br.com.nsbarros.android.compose.lojateniscompose.ui.screen.home.viewmodel.HomeViewModel
import br.com.nsbarros.android.compose.lojateniscompose.ui.theme.LojaTenisComposeTheme
import org.koin.androidx.compose.koinViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LojaTenisComposeTheme {

                val homeViewModel: HomeViewModel = koinViewModel()

                AppNavHost(viewModel = homeViewModel)
            }
        }
    }
}