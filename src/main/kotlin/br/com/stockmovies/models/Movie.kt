package br.com.stockmovies.models

import com.fasterxml.jackson.annotation.JsonManagedReference
import java.math.BigDecimal
import javax.persistence.*

@Entity
data class Movie(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        val title: String,

        val originalTitle: String,

        val overview: String,

        var pictureUrl: String?,

        val studio: String,

        val country: String,

        val releaseDate: String,

        val status: String,

        @Column(name = "tagline")
        val tagLine: String,

        val voteAverage: Double,

        val voteCount: Int,

        val budget: BigDecimal,

        val originalLanguage: String,

        val revenue: BigDecimal,

        val popularity: Int,

        val runtime: Int,

        var stockPrice: BigDecimal,

        var quantityAvailable: Long,

        @JsonManagedReference
        @OneToMany(mappedBy = "movie")
        val cast: List<Cast> = arrayListOf(),

        @JsonManagedReference
        @ManyToMany
        @JoinTable(
                name = "genre_movie",
                joinColumns = [JoinColumn(name = "movie_id")],
                inverseJoinColumns = [JoinColumn(name = "genre_id")]
        )
        val genres: List<Genre> = arrayListOf(),

        @JsonManagedReference
        @OneToMany(mappedBy = "movie")
        val production: List<Department> = arrayListOf()
)