package br.com.stockmovies.controllers

import br.com.stockmovies.models.Movie
import br.com.stockmovies.repositories.MovieRepository
import br.com.stockmovies.services.MovieService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/movies")
class MovieController(private val movieService: MovieService) {


    @GetMapping
    fun listAll(pageable: Pageable): Page<Movie> {
        return movieService.listAll(pageable)
    }
}