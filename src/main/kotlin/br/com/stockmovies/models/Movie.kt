package br.com.stockmovies.models

import java.math.BigDecimal
import javax.persistence.*

@Entity
data class Movie(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        val title: String,

        val overview: String,

        val pictureUrl: String,

        val budget: BigDecimal,

        val revenue: BigDecimal,

        val popularity: Int,

        val stockPrice: BigDecimal,

        val quantityAvailable: Long,

        @ManyToMany
        val cast: List<People> = arrayListOf(),

        @ManyToMany
        val director: List<People> = arrayListOf(),

        @ManyToOne
        val studio: Studio
)