package br.com.stockmovies.models

import java.math.BigDecimal
import javax.persistence.*

@Entity
data class Position(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @ManyToOne
        val movie: Movie,

        @ManyToOne
        val user: User,

        val quantity: Long,

        val mediumPrice: BigDecimal
)
