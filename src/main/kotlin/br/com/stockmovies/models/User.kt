package br.com.stockmovies.models

import javax.persistence.*

@Entity
data class User(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        val name: String,
        val login: String,
        val password: String,
        val pictureUrl: String,

        @OneToMany(mappedBy = "user")
        val wallet: List<Position>,

        @OneToMany(mappedBy = "user")
        val buyOrders: List<BuyOrder>
)