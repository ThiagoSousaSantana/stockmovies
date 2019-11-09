package br.com.stockmovies.services

import br.com.stockmovies.models.Movie
import br.com.stockmovies.repositories.MovieRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class MovieService(private val movieRepository: MovieRepository) {

    fun listAll(pageable: Pageable): Page<Movie>{
        return movieRepository.findAll(pageable)
    }

}