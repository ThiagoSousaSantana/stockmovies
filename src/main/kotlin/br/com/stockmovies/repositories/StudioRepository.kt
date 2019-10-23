package br.com.stockmovies.repositories

import br.com.stockmovies.models.Studio
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudioRepository : JpaRepository<Studio, Long>