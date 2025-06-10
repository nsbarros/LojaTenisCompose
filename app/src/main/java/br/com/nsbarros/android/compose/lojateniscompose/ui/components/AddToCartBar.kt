package br.com.nsbarros.android.compose.lojateniscompose.ui.components


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.nsbarros.android.compose.lojateniscompose.ui.theme.BackgroundLight
import br.com.nsbarros.android.compose.lojateniscompose.ui.theme.Primary
import br.com.nsbarros.android.compose.lojateniscompose.ui.theme.WhiteText

@Composable
fun AddToCartBar(
    modifier: Modifier = Modifier,
    onAddToCart: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .height(56.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Primary)
                .clickable { onAddToCart() },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Adicionar no carrinho",
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                color = WhiteText,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        IconButton(
            onClick = onAddToCart,
            modifier = Modifier
                .size(56.dp)
                .background(BackgroundLight, CircleShape)
                .border(2.dp, color = Primary, RoundedCornerShape(20.dp))
        ) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Carrinho",
                tint = Primary
            )
        }
    }
}