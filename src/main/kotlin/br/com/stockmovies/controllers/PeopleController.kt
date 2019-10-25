package br.com.stockmovies.controllers

import br.com.stockmovies.models.People
import br.com.stockmovies.models.requests.PeopleRequest
import br.com.stockmovies.services.PeopleService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/people")
class PeopleController(val peopleService: PeopleService) {

    @PostMapping
    fun insert(@Valid @RequestBody peopleRequest: PeopleRequest): People {
        return peopleService.save(People(peopleRequest))
    }
}