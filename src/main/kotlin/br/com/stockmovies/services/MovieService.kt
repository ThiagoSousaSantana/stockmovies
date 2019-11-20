package br.com.stockmovies.services

import br.com.stockmovies.models.Movie
import br.com.stockmovies.repositories.MovieRepository
import br.com.stockmovies.services.exceptions.ResourceNotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class MovieService(private val movieRepository: MovieRepository) {

    fun findAll(pageable: Pageable, title: String?): Page<Movie>{
        return if (title == null) {
            movieRepository.findAll(pageable)
        } else {
            movieRepository.findAllByTitleContains(pageable, title)
        }
    }

    fun findById(id: Long): Movie {
        return movieRepository.findById(id).orElseThrow { ResourceNotFoundException("Movie not found with id: $id") }
    }

}