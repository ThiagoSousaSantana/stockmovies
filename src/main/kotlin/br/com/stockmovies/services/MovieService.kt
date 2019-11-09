package br.com.stockmovies.services

import br.com.stockmovies.models.Movie
import br.com.stockmovies.repositories.MovieRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class MovieService(private val movieRepository: MovieRepository, private val omdbService: OMDBService) {

    fun listAll(pageable: Pageable): Page<Movie>{
        val movies = movieRepository.findAll(pageable)

        movies.forEach {
            if (it.pictureUrl == null) {
                val url = omdbService.getPoster(it.originalTitle)
                if (url.isEmpty()) {
                    movieRepository.delete(it)
                }
                it.pictureUrl = url
                movieRepository.save(it)
            }

        }
        return movies
    }

}