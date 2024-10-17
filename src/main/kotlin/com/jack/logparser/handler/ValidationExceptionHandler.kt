package com.jack.logparser.handler

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

data class ErrorResponse(
    val status: HttpStatus,
    val message: String,
    val errors: Map<String, String> = emptyMap(),
)

@ControllerAdvice
class ValidationExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationExceptions(ex: MethodArgumentNotValidException): ResponseEntity<ErrorResponse> {
        val errorResponse =
            ErrorResponse(
                status = HttpStatus.INTERNAL_SERVER_ERROR,
                message = "An unexpected error occurred",
                errors = mapOf("error" to (ex.message ?: "Unknown error")),
            )

        return ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST)
    }
}
