package br.com.nsbarros.android.compose.lojateniscompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.nsbarros.android.compose.lojateniscompose.ui.theme.BackgroundLight
import br.com.nsbarros.android.compose.lojateniscompose.ui.theme.Primary
import br.com.nsbarros.android.compose.lojateniscompose.ui.theme.Secondary

@Composable
fun ProductSearchBar(
    query: String,
    onQueryChanged: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(BackgroundLight, RoundedCornerShape(12.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = query,
            onValueChange = onQueryChanged,
            placeholder = { Text("Pesquisar") },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,

                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,

                cursorColor = Secondary,
                focusedTextColor = Secondary,
                unfocusedTextColor = Secondary,
                disabledTextColor = Secondary,

                focusedPlaceholderColor = Secondary,
                unfocusedPlaceholderColor = Secondary,
                disabledPlaceholderColor = Secondary
            ),
            modifier = Modifier
                .weight(1f)
                .padding(start = 12.dp)
                .border(
                    width = 1.dp,
                    color = Secondary,
                    shape = RoundedCornerShape(20.dp)
                )
                .clip(RoundedCornerShape(20.dp))
        )
        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Buscar",
                tint = Color.White,
                modifier = Modifier
                    .background(Primary, RoundedCornerShape(100))
                    .height(50.dp)
                    .padding(8.dp)

            )
        }
    }
}