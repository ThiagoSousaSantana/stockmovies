package br.com.stockmovies.services

import br.com.stockmovies.models.User
import br.com.stockmovies.models.dtos.UserAuthentication
import br.com.stockmovies.repositories.UserRepository
import br.com.stockmovies.services.exceptions.ResourceNotFoundException
import org.springframework.stereotype.Service
import java.security.InvalidParameterException
import javax.naming.AuthenticationException

@Service
class UserService(private val userRepository: UserRepository) {

    fun insert(user: User): User {
        if (userRepository.existsByEmail(user.email)) {
            throw InvalidParameterException("User with email: '${user.email}' already exists")
        }
        return userRepository.save(user.copy(id = null))
    }

    fun authenticate(userAuthentication: UserAuthentication): User {
        val user = userRepository.findByEmail(userAuthentication.email).orElseThrow {
            throw AuthenticationException("Invalid email: '${userAuthentication.email}'")
        }

        if (user.password == userAuthentication.password) {
            return user
        } else {
            throw AuthenticationException("Invalid password")
        }
    }

    fun findById(userId: Long): User {
        return userRepository.findById(userId).orElseThrow { ResourceNotFoundException("User not found with id '$userId'") }
    }

}
