package br.com.stockmovies.controllers

import br.com.stockmovies.models.User
import br.com.stockmovies.models.dtos.UserAuthentication
import br.com.stockmovies.models.dtos.UserRequest
import br.com.stockmovies.models.dtos.UserResume
import br.com.stockmovies.services.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("users")
class UserController(val userService: UserService) {

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): ResponseEntity<UserResume> {
        return ResponseEntity.ok(UserResume(userService.findById(id)))
    }

    @PostMapping
    fun insertUser(@RequestBody @Valid user: UserRequest): ResponseEntity<User> {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.insert(User(user)))
    }

    @PostMapping("/auth")
    fun authenticate(@RequestBody @Valid userAuthentication: UserAuthentication): ResponseEntity<User> {
        return ResponseEntity.ok(userService.authenticate(userAuthentication))
    }
}