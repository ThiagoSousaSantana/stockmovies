package br.com.stockmovies.repositories

import br.com.stockmovies.models.People
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PeopleRepository : JpaRepository<People, Long>