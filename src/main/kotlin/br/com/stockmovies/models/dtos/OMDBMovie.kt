package br.com.stockmovies.models.dtos

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class OMDBMovie(
        @JsonProperty("Poster")
        val poster: String
)