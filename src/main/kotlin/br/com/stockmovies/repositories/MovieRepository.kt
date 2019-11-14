package br.com.stockmovies.repositories

import br.com.stockmovies.models.Movie
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MovieRepository : JpaRepository<Movie, Long> {
    fun findAllByTitleContains(pageable: Pageable, title: String): Page<Movie>
}