package br.com.stockmovies.services.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.security.InvalidParameterException
import javax.naming.AuthenticationException

@ControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(value = [AuthenticationException::class])
    fun authenticationException(exception: AuthenticationException): ResponseEntity<StandartError> {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(StandartError(
                message = exception.message ?: "",
                status = HttpStatus.UNAUTHORIZED.value(),
                timestamp = System.currentTimeMillis()
        ))
    }

    @ExceptionHandler(value = [InvalidParameterException::class])
    fun invalidParameterException(exception: InvalidParameterException): ResponseEntity<StandartError> {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(StandartError(
                message = exception.message ?: "",
                status = HttpStatus.BAD_REQUEST.value(),
                timestamp = System.currentTimeMillis()
        ))
    }
}