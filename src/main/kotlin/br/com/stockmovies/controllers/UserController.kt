package br.com.stockmovies.controllers

import br.com.stockmovies.models.User
import br.com.stockmovies.models.dtos.UserRequest
import br.com.stockmovies.services.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("users")
class UserController(val userService: UserService) {

    @PostMapping
    fun insertUser(@RequestBody @Valid user: UserRequest): ResponseEntity<User> {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.insert(User(user)))
    }
}