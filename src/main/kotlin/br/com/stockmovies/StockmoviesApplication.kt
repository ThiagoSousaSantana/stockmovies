package br.com.stockmovies

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StockmoviesApplication

fun main(args: Array<String>) {
	runApplication<StockmoviesApplication>(*args)
}
