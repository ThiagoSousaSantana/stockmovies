package br.com.stockmovies.services

import br.com.stockmovies.models.People
import br.com.stockmovies.repositories.PeopleRepository
import org.springframework.stereotype.Service

@Service
class PeopleService(private val peopleRepository: PeopleRepository ) {

    fun save(people: People): People {
        people.id = null
        return peopleRepository.save(people)
    }
}