package br.com.stockmovies.models

import br.com.stockmovies.models.dtos.UserRequest
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import java.math.BigDecimal
import javax.persistence.*

@Entity
data class User(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val name: String,
        val email: String,
        var balance: BigDecimal,

        @JsonIgnore
        val password: String,

        @JsonManagedReference
        @OneToMany(mappedBy = "user")
        val wallet: List<Position> = arrayListOf(),

        @JsonManagedReference
        @OneToMany(mappedBy = "user")
        val buyOrders: List<BuyOrder> = arrayListOf()
) {
    constructor(user: UserRequest) : this(
            name = user.name,
            email = user.email,
            password = user.password,
            balance = BigDecimal.valueOf(10000)
    )
}