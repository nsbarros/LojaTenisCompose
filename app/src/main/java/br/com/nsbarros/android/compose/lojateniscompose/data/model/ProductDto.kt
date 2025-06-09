package br.com.nsbarros.android.compose.lojateniscompose.data.model

data class ProductDto(
    val id: String,
    val name: String,
    val imageUrl: String,
    val price: Double,
    val category: String,
    val description: String,
    val rating: Double,
    val isFavorite: Boolean
)