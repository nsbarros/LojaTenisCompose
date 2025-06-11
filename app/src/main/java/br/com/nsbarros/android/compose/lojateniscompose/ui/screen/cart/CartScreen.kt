package br.com.nsbarros.android.compose.lojateniscompose.ui.screen.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import br.com.nsbarros.android.compose.lojateniscompose.ui.theme.BackgroundLight


@Composable
fun CartScreen() {
    Scaffold(
    ) { padding ->
        Box(
            modifier = Modifier
                .background(color = BackgroundLight)
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Carrinho", style = MaterialTheme.typography.titleLarge)
        }
    }
}