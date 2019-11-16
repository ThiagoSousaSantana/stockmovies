package br.com.stockmovies.services

import br.com.stockmovies.models.Movie
import br.com.stockmovies.repositories.MovieRepository
import br.com.stockmovies.services.exceptions.ResourceNotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class MovieService(private val movieRepository: MovieRepository, private val omdbService: OMDBService) {

    fun findAll(pageable: Pageable, title: String?): Page<Movie>{
        val movies = if (title == null) {
            movieRepository.findAll(pageable)
        } else {
            movieRepository.findAllByTitleContains(pageable, title)
        }

        var count = 0
        movies.forEach {
            if (it.pictureUrl == null && count < 1000) {
                val url = omdbService.getPoster(it.originalTitle)
                count++
                if (url.isEmpty() || url == "N/A") {
                    movieRepository.delete(it)
                } else {
                    it.pictureUrl = url
                    movieRepository.save(it)
                }
            }
        }
        return movies
    }

    fun findById(id: Long): Movie {
        return movieRepository.findById(id).orElseThrow { ResourceNotFoundException("Movie not found with id: $id") }
    }

}