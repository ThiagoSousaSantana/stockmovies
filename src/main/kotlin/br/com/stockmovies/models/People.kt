package br.com.stockmovies.models

import br.com.stockmovies.models.requests.PeopleRequest
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class People(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        val name: String,
        val pictureUrl: String
) {
        constructor(peopleRequest: PeopleRequest) : this(
                name = peopleRequest.name,
                pictureUrl = peopleRequest.pictureUrl
        )
}
