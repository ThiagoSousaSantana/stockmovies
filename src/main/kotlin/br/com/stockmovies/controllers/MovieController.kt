package br.com.stockmovies.controllers

import br.com.stockmovies.models.Movie
import br.com.stockmovies.models.dtos.MovieResume
import br.com.stockmovies.services.MovieService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.websocket.server.PathParam

@RestController
@RequestMapping("/movies")
class MovieController(private val movieService: MovieService) {


    @GetMapping
    fun listAll(pageable: Pageable, title: String?): Page<MovieResume> {
        return movieService.findAll(pageable, title).map { MovieResume(it)}
    }

    @GetMapping("/{id}")
    fun findMovie(@PathVariable id: Long): ResponseEntity<Movie> {
        return ResponseEntity.ok(movieService.findById(id))
    }
}