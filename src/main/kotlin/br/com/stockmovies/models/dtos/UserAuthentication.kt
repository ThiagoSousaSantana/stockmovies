package br.com.stockmovies.models.dtos

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class UserAuthentication(
        @field: Email
        val email: String,
        @field: NotBlank
        val password: String
)