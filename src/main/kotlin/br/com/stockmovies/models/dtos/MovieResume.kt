package br.com.stockmovies.models.dtos

import br.com.stockmovies.models.Movie

data class MovieResume(
        val id: Long,
        val title: String,
        var pictureUrl: String
) {
    constructor(movie: Movie) : this(
            id = movie.id,
            title = movie.title,
            pictureUrl = movie.pictureUrl ?: ""
    )
}