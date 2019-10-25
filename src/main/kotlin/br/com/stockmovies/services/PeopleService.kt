package br.com.stockmovies.services

import br.com.stockmovies.models.People
import br.com.stockmovies.repositories.PeopleRepository
import br.com.stockmovies.services.exceptions.ResourceNotFoundEsception
import org.springframework.stereotype.Service

@Service
class PeopleService(private val peopleRepository: PeopleRepository ) {

    fun save(people: People): People {
        people.id = null
        return peopleRepository.save(people)
    }

    fun findById(peopleId: Long): People {
        return peopleRepository.findById(peopleId).orElseThrow {
            ResourceNotFoundEsception("People with ID: $peopleId not found") }
    }
}