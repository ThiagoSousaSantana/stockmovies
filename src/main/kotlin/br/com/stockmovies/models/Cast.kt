package br.com.stockmovies.models

import javax.persistence.*

@Entity
data class Cast(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @ManyToOne
        @JoinColumn(name = "movieid")
        val movie: Movie,

        val character: String,

        val actor: String
)