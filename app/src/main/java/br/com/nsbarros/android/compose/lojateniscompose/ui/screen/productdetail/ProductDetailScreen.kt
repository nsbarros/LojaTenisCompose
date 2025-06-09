package br.com.nsbarros.android.compose.lojateniscompose.ui.screen.productdetail

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import br.com.nsbarros.android.compose.lojateniscompose.domain.model.Product
import androidx.compose.material3.TopAppBar

@Composable
fun ProductDetailScreen(
    product: Product,
    onBack: () -> Unit
) {
    Scaffold(
        /*topBar = {
            SmallTopAppBar(
                title = { Text(text = product.name) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                },
                scrollBehavior = null // 👈 isso remove o erro
            )
        }*/
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = product.imageUrl,
                contentDescription = product.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = product.name,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "R$ ${product.price}",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )

            Text(
                text = "Avaliação: ${product.rating}",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = product.description,
                style = MaterialTheme.typography.bodySmall,
                fontSize = 14.sp
            )
        }
    }
}