package br.com.stockmovies.models

import java.math.BigDecimal
import javax.persistence.*

@Entity
data class Movie(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        val title: String,

        val originalTitle: String,

        val overview: String,

        val pictureUrl: String,

        val studio: String,

        val country: String,

        val releaseDate: String,

        val status: String,

        val tagLine: String,

        val voteAverage: Int,

        val voteCount: Int,

        val budget: BigDecimal,

        val originalLanguage: String,

        val revenue: BigDecimal,

        val popularity: Int,

        val runtime: Int,

        val stockPrice: BigDecimal,

        val quantityAvailable: Long,

        @OneToMany(mappedBy = "movie")
        val cast: List<Cast> = arrayListOf(),

        @ManyToMany
        @JoinTable(
                name = "genre_movie",
                joinColumns = [JoinColumn(name = "movie_id")],
                inverseJoinColumns = [JoinColumn(name = "genre_id")]
        )
        val genres: List<Genre> = arrayListOf(),

        @OneToMany(mappedBy = "movie")
        val production: List<Department> = arrayListOf()
)