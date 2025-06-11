package br.com.nsbarros.android.compose.lojateniscompose.data.datasource

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import br.com.nsbarros.android.compose.lojateniscompose.data.model.ProductDto

object FakeProductDataSource {

    val products = listOf(
        ProductDto(
            id = "1",
            name = "Tênis Air Zoom",
            imageUrl = "https://imgnike-a.akamaihd.net/360x360/027279IMA8.jpg",
            price = 299.99,
            category = "Tênis",
            description = "Dê as boas-vindas à próxima geração do Air Max. Este modelo contemporâneo e deslumbrante homenageia o rico legado do Air Max com um cabedal em mesh multicamadas com estampa tátil e iconografia tradicional, detalhes foscos para um visual magnético e um inovador sistema de unidade Dynamic Air, projetado para fazer com que caminhar pareça deslizar no ar.",
            rating = 4.5,
            isFavorite = false
        ),
        ProductDto(
            id = "2",
            name = "Chuteira Pro Max",
            imageUrl = "https://imgnike-a.akamaihd.net/360x360/094381IDA1.jpg",
            price = 199.99,
            category = "Chuteira",
            description = "Dê as boas-vindas à próxima geração do Air Max. Este modelo contemporâneo e deslumbrante homenageia o rico legado do Air Max com um cabedal em mesh multicamadas com estampa tátil e iconografia tradicional, detalhes foscos para um visual magnético e um inovador sistema de unidade Dynamic Air, projetado para fazer com que caminhar pareça deslizar no ar.",
            rating = 4.8,
            isFavorite = true
        ),
        ProductDto(
            id = "3",
            name = "Tênis Street Vibe",
            imageUrl = "https://imgnike-a.akamaihd.net/360x360/052505IDA1.jpg",
            price = 249.99,
            category = "Tênis",
            description = LoremIpsum(50).values.joinToString(" "),
            rating = 4.2,
            isFavorite = false
        ),
        ProductDto(
            id = "4",
            name = "Sapatênis Classic Fit",
            imageUrl = "https://imgnike-a.akamaihd.net/360x360/058444IDA1.jpg",
            price = 179.90,
            category = "Sapatênis",
            description = LoremIpsum(50).values.joinToString(" "),
            rating = 4.0,
            isFavorite = true
        ),
        ProductDto(
            id = "5",
            name = "Bota Adventure Pro",
            imageUrl = "https://imgnike-a.akamaihd.net/768x768/028676CT.jpg",
            price = 320.00,
            category = "Bota",
            description = LoremIpsum(50).values.joinToString(" "),
            rating = 4.6,
            isFavorite = false
        ),
        ProductDto(
            id = "6",
            name = "Fake Shoes 6",
            imageUrl = "https://imgnike-a.akamaihd.net/768x768/029400ND.jpg",
            price = 320.00,
            category = "Bota",
            description = LoremIpsum(50).values.joinToString(" "),
            rating = 4.6,
            isFavorite = false
        ),
        ProductDto(
            id = "7",
            name = "Fake Shoes 7",
            imageUrl = "https://imgnike-a.akamaihd.net/768x768/07480256.jpg",
            price = 320.00,
            category = "Bota",
            description = LoremIpsum(50).values.joinToString(" "),
            rating = 4.6,
            isFavorite = false
        ),
        ProductDto(
            id = "8",
            name = "Fake Shoes 8",
            imageUrl = "https://imgnike-a.akamaihd.net/768x768/0289850L.jpg",
            price = 320.00,
            category = "Bota",
            description = LoremIpsum(50).values.joinToString(" "),
            rating = 4.6,
            isFavorite = false
        ),
        ProductDto(
            id = "9",
            name = "Fake Shoes 9",
            imageUrl = "https://imgnike-a.akamaihd.net/768x768/027317MU.jpg",
            price = 320.00,
            category = "Bota",
            description = LoremIpsum(50).values.joinToString(" "),
            rating = 4.6,
            isFavorite = false
        ),
        ProductDto(
            id = "10",
            name = "Fake Shoes 10",
            imageUrl = "https://imgnike-a.akamaihd.net/768x768/024252ND.jpg",
            price = 320.00,
            category = "Bota",
            description = LoremIpsum(50).values.joinToString(" "),
            rating = 4.6,
            isFavorite = false
        ),
        ProductDto(
            id = "11",
            name = "Fake Shoes 11",
            imageUrl = "https://imgnike-a.akamaihd.net/768x768/009351ID.jpg",
            price = 320.00,
            category = "Bota",
            description = LoremIpsum(50).values.joinToString(" "),
            rating = 4.6,
            isFavorite = false
        ),
        ProductDto(
            id = "12",
            name = "Fake Shoes 12",
            imageUrl = "https://imgnike-a.akamaihd.net/768x768/01370252.jpg",
            price = 320.00,
            category = "Bota",
            description = LoremIpsum(50).values.joinToString(" "),
            rating = 4.6,
            isFavorite = false
        )
    )
}