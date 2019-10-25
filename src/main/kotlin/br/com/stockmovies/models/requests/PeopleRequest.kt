package br.com.stockmovies.models.requests

import javax.validation.constraints.NotEmpty

data class PeopleRequest(
        @field:NotEmpty
        val name: String,
        val pictureUrl: String
)
