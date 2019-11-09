package br.com.stockmovies.models

import br.com.stockmovies.models.dtos.UserRequest
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class User(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val name: String,
        val email: String,
        @JsonIgnore
        val password: String,

        @OneToMany(mappedBy = "user")
        val wallet: List<Position> = arrayListOf(),

        @OneToMany(mappedBy = "user")
        val buyOrders: List<BuyOrder> = arrayListOf()
) {
    constructor(user: UserRequest) : this(
            name = user.name,
            email = user.email,
            password = user.password
    )
}