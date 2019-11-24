package br.com.stockmovies.models.dtos

import br.com.stockmovies.models.BuyOrder
import java.math.BigDecimal
import java.time.LocalDateTime

data class BuyOrderResume(
        val id: Long,
        val movie: MovieResume,
        val quantity: Long,
        val price: BigDecimal,
        val date: LocalDateTime
) {
    constructor(buyOrder: BuyOrder) : this(
            id = buyOrder.id ?: 0,
            movie = MovieResume(buyOrder.movie),
            quantity = buyOrder.quantity,
            price = buyOrder.price,
            date = buyOrder.date
    )
}
