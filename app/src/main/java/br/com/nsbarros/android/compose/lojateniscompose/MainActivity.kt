package br.com.nsbarros.android.compose.lojateniscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import br.com.nsbarros.android.compose.lojateniscompose.ui.theme.LojaTenisComposeTheme
import br.com.nsbarros.android.compose.lojateniscompose.ui.theme.home.screen.HomeScreen
import br.com.nsbarros.android.compose.lojateniscompose.ui.theme.home.viewmodel.HomeViewModel
import org.koin.androidx.compose.koinViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LojaTenisComposeTheme {
                val viewModel: HomeViewModel = koinViewModel()
                val state by viewModel.state.collectAsState()

                HomeScreen(
                    state = state,
                    onEvent = viewModel::onEvent
                )
            }
        }
    }
}