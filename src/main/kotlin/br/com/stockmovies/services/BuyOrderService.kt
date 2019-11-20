package br.com.stockmovies.services

import br.com.stockmovies.models.BuyOrder
import br.com.stockmovies.models.Position
import br.com.stockmovies.models.dtos.BuyOrderRequest
import br.com.stockmovies.repositories.BuyOrderRepository
import br.com.stockmovies.repositories.PositionRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.security.InvalidParameterException

@Service
class BuyOrderService(
        private val buyOrderRepository: BuyOrderRepository,
        private val userService: UserService,
        private val positionRepository: PositionRepository,
        private val movieService: MovieService
) {

    fun insert(request: BuyOrderRequest) {
        val user = userService.findById(request.userId)
        val movie = movieService.findById(request.movieId)

        if (movie.quantityAvailable < request.quantity) {
            throw InvalidParameterException("Stock quantity invalid")
        }

        val valueTotal = request.quantity.times(movie.stockPrice.toDouble())

        if (user.balance.toDouble() < valueTotal) {
            throw InvalidParameterException("User don't have balance enough")
        }

        val order = BuyOrder(
                id = null,
                movie = movie,
                user = user,
                price = movie.stockPrice,
                quantity = request.quantity
        )

        buyOrderRepository.save(order)

        movie.quantityAvailable -= request.quantity
        user.balance = user.balance.minus(BigDecimal.valueOf(valueTotal))

        val positionExists = user.wallet.find { position -> position.movie == movie }

        if (positionExists == null) {
            positionRepository.save(
                    Position(
                            id = null,
                            quantity = request.quantity,
                            user = user,
                            movie = movie,
                            mediumPrice = movie.stockPrice
                    )
            )
        } else {
            positionExists.quantity += request.quantity
            positionRepository.save(positionExists)
        }
    }

}
