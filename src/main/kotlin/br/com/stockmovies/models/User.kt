package br.com.stockmovies.models

import br.com.stockmovies.models.dtos.UserRequest
import javax.persistence.*

@Entity
data class User(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val name: String,
        val email: String,
        val login: String,
        val password: String,
        val pictureUrl: String,

        @OneToMany(mappedBy = "user")
        val wallet: List<Position> = arrayListOf(),

        @OneToMany(mappedBy = "user")
        val buyOrders: List<BuyOrder> = arrayListOf()
) {
    constructor(user: UserRequest) : this(
            name = user.name,
            email = user.email,
            login = user.login,
            password = user.password,
            pictureUrl = user.pictureUrl
    )
}