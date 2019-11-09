package br.com.stockmovies.models

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
data class Department(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @JsonBackReference
        @ManyToOne
        @JoinColumn(name = "movie_id")
        val movie: Movie,

        val department: String,

        val job: String,

        val name: String
)