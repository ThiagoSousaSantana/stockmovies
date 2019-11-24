package br.com.stockmovies.models.dtos

import br.com.stockmovies.models.User
import java.math.BigDecimal

data class UserResume(
        val id: Long,
        val name: String,
        val email: String,
        var balance: BigDecimal,
        val wallet: List<PositionResume> = arrayListOf(),
        val buyOrders: List<BuyOrderResume> = arrayListOf()
) {
    constructor(user: User): this(
            id = user.id ?: 0,
            name = user.name,
            email = user.email,
            balance = user.balance,
            wallet = user.wallet.map { PositionResume(it) },
            buyOrders = user.buyOrders.map { BuyOrderResume(it) }
    )
}