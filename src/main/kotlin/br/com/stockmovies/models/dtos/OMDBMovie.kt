package br.com.stockmovies.models.dtos

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class OMDBMovie(val Poster: String)