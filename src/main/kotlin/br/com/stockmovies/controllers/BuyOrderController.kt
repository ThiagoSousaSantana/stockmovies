package br.com.stockmovies.controllers

import br.com.stockmovies.models.dtos.BuyOrderRequest
import br.com.stockmovies.services.BuyOrderService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/orders")
class BuyOrderController(private val buyOrderService: BuyOrderService) {

    @PostMapping
    fun buyOrder(@RequestBody buyOrderRequest: BuyOrderRequest) {

    }
}