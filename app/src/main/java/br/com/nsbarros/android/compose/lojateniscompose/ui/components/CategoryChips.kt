package br.com.nsbarros.android.compose.lojateniscompose.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.nsbarros.android.compose.lojateniscompose.ui.theme.BackgroundLight
import br.com.nsbarros.android.compose.lojateniscompose.ui.theme.Primary
import br.com.nsbarros.android.compose.lojateniscompose.ui.theme.Secondary
import br.com.nsbarros.android.compose.lojateniscompose.ui.theme.WhiteText

@Composable
fun CategoryChips(
    categories: List<String>,
    selectedCategory: String,
    onCategorySelected: (String) -> Unit
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(categories) { category ->
            val isSelected = category == selectedCategory
            FilterChip(
                selected = isSelected,
                onClick = { onCategorySelected(category) },
                label = {
                    Text(
                        text = category,
                        color = if (isSelected) WhiteText else Secondary
                    )
                },
                colors = FilterChipDefaults.filterChipColors(
                    containerColor = if (isSelected) Primary else BackgroundLight,
                    selectedContainerColor = Primary,
                    labelColor = if (isSelected) WhiteText else Secondary,
                    selectedLabelColor = WhiteText
                ),
                shape = RoundedCornerShape(20.dp),
                border = FilterChipDefaults.filterChipBorder(
                    enabled = true,
                    selected = isSelected,
                    borderColor = if (isSelected) Color.Transparent else Secondary
                )
            )
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}