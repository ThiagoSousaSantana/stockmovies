package br.com.stockmovies.models

import javax.persistence.*

@Entity
data class Movie(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        val name: String,
        val description: String,
        val pictureUrl: String,
        @ManyToMany
        val cast: List<People> = arrayListOf(),
        @ManyToMany
        val director: List<People> = arrayListOf(),
        @ManyToOne
        val studio: Studio
)