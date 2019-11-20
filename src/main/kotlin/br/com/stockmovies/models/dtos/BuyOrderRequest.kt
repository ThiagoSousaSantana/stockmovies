package br.com.stockmovies.models.dtos

data class BuyOrderRequest(
        val movieId: Long,
        val userId: Long,
        val quantity: Long
)
