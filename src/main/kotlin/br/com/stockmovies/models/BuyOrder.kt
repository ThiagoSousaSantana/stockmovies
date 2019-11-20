package br.com.stockmovies.models

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class BuyOrder(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?,

        @JsonBackReference
        @ManyToOne
        val movie: Movie,

        @JsonBackReference
        @ManyToOne
        val user: User,

        val quantity: Long,

        val price: BigDecimal,

        val date: LocalDateTime = LocalDateTime.now()
)

