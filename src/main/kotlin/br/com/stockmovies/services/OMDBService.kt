package br.com.stockmovies.services

import br.com.stockmovies.models.dtos.OMDBMovie
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject

@Service
class OMDBService {

    private val restTemplate: RestTemplate = RestTemplate()
    private val OMDB_URL= "http://www.omdbapi.com/"
    private val API_KEY = "9a56e223"

    fun getPoster(movieName: String): String {
        return try {
            val omdbMovie: OMDBMovie = restTemplate.getForObject(
                    "$OMDB_URL/?apikey=$API_KEY&t=${movieName.replace(' ', '+')}",
                    OMDBMovie::class
            )
            omdbMovie.poster
        } catch (e: Exception) {
            ""
        }
    }
}