package br.com.nsbarros.android.compose.lojateniscompose.data.mapper

import br.com.nsbarros.android.compose.lojateniscompose.data.model.ProductDto
import br.com.nsbarros.android.compose.lojateniscompose.domain.model.Product

fun ProductDto.toDomain(): Product {
    return Product(
        id = id,
        name = name,
        imageUrl = imageUrl,
        price = price,
        category = category,
        description = description,
        rating = rating,
        isFavorite = isFavorite
    )
}