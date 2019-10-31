package br.com.stockmovies.controllers

import br.com.stockmovies.models.People
import br.com.stockmovies.models.requests.PeopleRequest
import br.com.stockmovies.services.PeopleService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/peoples")
class PeopleController(val peopleService: PeopleService) {

    @PostMapping
    fun insert(@Valid @RequestBody peopleRequest: PeopleRequest): People {
        return peopleService.save(People(peopleRequest))
    }

    @GetMapping(value = ["/{peopleId}"])
    fun findById(@PathVariable peopleId: Long): People {
        return peopleService.findById(peopleId)
    }

}