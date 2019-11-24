package br.com.stockmovies.models.dtos

import br.com.stockmovies.models.Position
import java.math.BigDecimal

data class PositionResume(
        val id: Long,
        val movie: MovieResume,
        var quantity: Long,
        val mediumPrice: BigDecimal
) {
    constructor(position: Position) : this(
            id = position.id ?: 0,
            movie = MovieResume(position.movie),
            quantity = position.quantity,
            mediumPrice = position.mediumPrice
    )
}