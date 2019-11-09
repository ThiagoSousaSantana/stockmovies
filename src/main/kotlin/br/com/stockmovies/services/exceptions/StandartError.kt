package br.com.stockmovies.services.exceptions

data class StandartError(
        val message: String,
        val status: Int,
        val timestamp: Long
)