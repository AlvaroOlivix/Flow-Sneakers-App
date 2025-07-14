package com.olivix.flow_snikers_app.feature.sneaker.data.remote

import com.olivix.flow_snikers_app.feature.sneaker.domain.Sneaker
import org.koin.core.annotation.Single

@Single
class MockRemoteSneakersDataSource {

    // Cinco ejemplos de Sneaker para mock

    private val mockSneakers = listOf(
        Sneaker(
            styleID = "AJ1-001",
            shoeName = "Jordan 4 Retro White Cement (2025)",
            brand = "Nike",
            thumbnail = "https://example.com/thumbnails/aj1-001-thumb.jpg",
            imageLinks = listOf(
                "https://example.com/images/aj1-001-1.jpg",
                "https://example.com/images/aj1-001-2.jpg"
            ),
            colorway = "Black/White",
            description = "Edición retro de la icónica Air Jordan 1, con cuero de primera calidad y suela Air original.",
            releaseDate = "2021-09-15"
        ),
        Sneaker(
            styleID = "YEEZY-350-V2-002",
            shoeName = "Yeezy Boost 350 V2",
            brand = "Adidas",
            thumbnail = "https://example.com/thumbnails/yeezy-350-v2-002-thumb.jpg",
            imageLinks = listOf(
                "https://example.com/images/yeezy-350-v2-002-1.jpg",
                "https://example.com/images/yeezy-350-v2-002-2.jpg",
                "https://example.com/images/yeezy-350-v2-002-3.jpg"
            ),
            colorway = "Zebra",
            description = "Suela Boost reactiva y parte superior Primeknit con un patrón a rayas en blanco y negro.",
            releaseDate = "2020-02-29"
        ),
        Sneaker(
            styleID = "ULTRABOOST-21-003",
            shoeName = "Ultraboost 21",
            brand = "Adidas",
            thumbnail = "https://example.com/thumbnails/ultraboost-21-003-thumb.jpg",
            imageLinks = listOf(
                "https://example.com/images/ultraboost-21-003-1.jpg"
            ),
            colorway = "Core Black",
            description = "Tecnología Boost mejorada con 6% más de energía de retorno, malla Primeknit+ transpirable.",
            releaseDate = "2021-04-01"
        ),
        Sneaker(
            styleID = "DUNK-LOW-004",
            shoeName = "Nike Dunk Low",
            brand = "Nike",
            thumbnail = "https://example.com/thumbnails/dunk-low-004-thumb.jpg",
            imageLinks = listOf(
                "https://example.com/images/dunk-low-004-1.jpg",
                "https://example.com/images/dunk-low-004-2.jpg"
            ),
            colorway = "White/University Blue",
            description = "Clásica Dunk Low con combinación de blanco y azul universitario en piel suave.",
            releaseDate = "2020-05-14"
        ),
        Sneaker(
            styleID = "SB-NIKE-005",
            shoeName = "Nike SB Dunk Low Pro",
            brand = "Nike",
            thumbnail = "https://example.com/thumbnails/sb-dunk-low-pro-005-thumb.jpg",
            imageLinks = listOf(
                "https://example.com/images/sb-dunk-low-pro-005-1.jpg",
                "https://example.com/images/sb-dunk-low-pro-005-2.jpg",
                "https://example.com/images/sb-dunk-low-pro-005-3.jpg"
            ),
            colorway = "Panda Black/White",
            description = "Versión skateboarding del Dunk Low, con extra acolchado y suela resistente al desgaste.",
            releaseDate = "2019-10-31"
        ),
        Sneaker(
            styleID = "AJ1-002",
            shoeName = "Jordan 4 Retro White Cement (2025)",
            brand = "Nike",
            thumbnail = "https://example.com/thumbnails/aj1-001-thumb.jpg",
            imageLinks = listOf(
                "https://example.com/images/aj1-001-1.jpg",
                "https://example.com/images/aj1-001-2.jpg"
            ),
            colorway = "Black/White",
            description = "Edición retro de la icónica Air Jordan 1, con cuero de primera calidad y suela Air original.",
            releaseDate = "2021-09-15"
        ),
        Sneaker(
            styleID = "YEEZY-350-V2-003",
            shoeName = "Yeezy Boost 350 V2",
            brand = "Adidas",
            thumbnail = "https://example.com/thumbnails/yeezy-350-v2-002-thumb.jpg",
            imageLinks = listOf(
                "https://example.com/images/yeezy-350-v2-002-1.jpg",
                "https://example.com/images/yeezy-350-v2-002-2.jpg",
                "https://example.com/images/yeezy-350-v2-002-3.jpg"
            ),
            colorway = "Zebra",
            description = "Suela Boost reactiva y parte superior Primeknit con un patrón a rayas en blanco y negro.",
            releaseDate = "2020-02-29"
        ),
        Sneaker(
            styleID = "ULTRABOOST-21-004",
            shoeName = "Ultraboost 21",
            brand = "Adidas",
            thumbnail = "https://example.com/thumbnails/ultraboost-21-003-thumb.jpg",
            imageLinks = listOf(
                "https://example.com/images/ultraboost-21-003-1.jpg"
            ),
            colorway = "Core Black",
            description = "Tecnología Boost mejorada con 6% más de energía de retorno, malla Primeknit+ transpirable.",
            releaseDate = "2021-04-01"
        ),
        Sneaker(
            styleID = "DUNK-LOW-005",
            shoeName = "Nike Dunk Low",
            brand = "Nike",
            thumbnail = "https://example.com/thumbnails/dunk-low-004-thumb.jpg",
            imageLinks = listOf(
                "https://example.com/images/dunk-low-004-1.jpg",
                "https://example.com/images/dunk-low-004-2.jpg"
            ),
            colorway = "White/University Blue",
            description = "Clásica Dunk Low con combinación de blanco y azul universitario en piel suave.",
            releaseDate = "2020-05-14"
        ),
        Sneaker(
            styleID = "SB-NIKE-006",
            shoeName = "Nike SB Dunk Low Pro",
            brand = "Nike",
            thumbnail = "https://example.com/thumbnails/sb-dunk-low-pro-005-thumb.jpg",
            imageLinks = listOf(
                "https://example.com/images/sb-dunk-low-pro-005-1.jpg",
                "https://example.com/images/sb-dunk-low-pro-005-2.jpg",
                "https://example.com/images/sb-dunk-low-pro-005-3.jpg"
            ),
            colorway = "Panda Black/White",
            description = "Versión skateboarding del Dunk Low, con extra acolchado y suela resistente al desgaste.",
            releaseDate = "2019-10-31"
        )
    )

    fun getList(): List<Sneaker> {
        return mockSneakers
    }

    fun getSneakerById(id: String): Sneaker? {
        return mockSneakers.find { id == it.styleID }
    }
}