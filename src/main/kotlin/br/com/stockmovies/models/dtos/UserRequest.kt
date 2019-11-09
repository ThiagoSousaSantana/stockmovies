package br.com.stockmovies.models.dtos

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class UserRequest(
        @field: NotBlank
        val name: String,
        @field: Email
        val email: String,
        @field: NotBlank
        val login: String,
        @field: NotBlank
        val password: String,
        val pictureUrl: String
)