package br.com.stockmovies.models.dtos

import java.math.BigDecimal

data class BuyOrderRequest(
        val movieId: Long,
        val userId: Long,
        val quantity: Long,
        val price: BigDecimal
)
