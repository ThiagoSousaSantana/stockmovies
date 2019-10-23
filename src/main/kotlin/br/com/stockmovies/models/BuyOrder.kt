package br.com.stockmovies.models

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class BuyOrder(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @ManyToOne
        val movie: Movie,

        @ManyToOne
        val user: User,

        val quantity: Long,

        val price: BigDecimal,

        val date: LocalDateTime = LocalDateTime.now()
)

