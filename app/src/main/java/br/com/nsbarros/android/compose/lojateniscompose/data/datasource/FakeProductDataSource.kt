package br.com.nsbarros.android.compose.lojateniscompose.data.datasource

import br.com.nsbarros.android.compose.lojateniscompose.data.model.ProductDto

object FakeProductDataSource {

    val products = listOf(
        ProductDto(
            id = "1",
            name = "Tênis Air Zoom",
            imageUrl = "https://imgnike-a.akamaihd.net/360x360/027279IMA8.jpg",
            price = 299.99,
            category = "Tênis",
            description = "Tênis esportivo leve e confortável, ideal para corrida e academia.",
            rating = 4.5,
            isFavorite = false
        ),
        ProductDto(
            id = "2",
            name = "Chuteira Pro Max",
            imageUrl = "https://imgnike-a.akamaihd.net/360x360/094381IDA1.jpg",
            price = 199.99,
            category = "Chuteira",
            description = "Chuteira profissional com solado antiderrapante e ótima tração em campo.",
            rating = 4.8,
            isFavorite = true
        ),
        ProductDto(
            id = "3",
            name = "Tênis Street Vibe",
            imageUrl = "https://imgnike-a.akamaihd.net/360x360/052505IDA1.jpg",
            price = 249.99,
            category = "Tênis",
            description = "Tênis casual com estilo urbano, ideal para o dia a dia.",
            rating = 4.2,
            isFavorite = false
        ),
        ProductDto(
            id = "4",
            name = "Sapatênis Classic Fit",
            imageUrl = "https://imgnike-a.akamaihd.net/360x360/058444IDA1.jpg",
            price = 179.90,
            category = "Sapatênis",
            description = "Sapatênis versátil com design moderno e acabamento premium.",
            rating = 4.0,
            isFavorite = true
        ),
        ProductDto(
            id = "5",
            name = "Bota Adventure Pro",
            imageUrl = "https://via.placeholder.com/150",
            price = 320.00,
            category = "Bota",
            description = "Bota resistente para trilhas e terrenos irregulares, com alta durabilidade.",
            rating = 4.6,
            isFavorite = false
        )
    )
}