package br.com.stockmovies.models

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import java.math.BigDecimal
import javax.persistence.*

@Entity
data class Position(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?,

        @JsonBackReference
        @ManyToOne
        val movie: Movie,

        @JsonBackReference
        @ManyToOne
        val user: User,

        var quantity: Long,

        val mediumPrice: BigDecimal
)
