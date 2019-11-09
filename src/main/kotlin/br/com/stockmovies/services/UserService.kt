package br.com.stockmovies.services

import br.com.stockmovies.models.User
import br.com.stockmovies.repositories.UserRepository
import org.springframework.stereotype.Service
import java.security.InvalidParameterException

@Service
class UserService(private val userRepository: UserRepository) {

    fun insert(user: User): User {
        if (userRepository.existsByEmail(user.email)) {
            throw InvalidParameterException("User with email: '${user.email}' already exists")
        }
        return userRepository.save(user.copy(id = null))
    }

}
