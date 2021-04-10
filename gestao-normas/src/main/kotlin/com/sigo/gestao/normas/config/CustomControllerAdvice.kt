package com.sigo.gestao.normas.config

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class CustomControllerAdvice : ResponseEntityExceptionHandler() {

    override fun handleMethodArgumentNotValid(
            ex: MethodArgumentNotValidException,
            headers: HttpHeaders,
            status: HttpStatus,
            request: WebRequest): ResponseEntity<Any> {
        val errors = ex.bindingResult.fieldErrors.map { it.defaultMessage!! }
        return buildResponseEntity(ApiError(HttpStatus.BAD_REQUEST, errors)) as ResponseEntity<Any>
    }

    class ApiError private constructor() {

        @JsonIgnore
        var status: HttpStatus? = null
        var message: Any? = null


        constructor(status: HttpStatus, message: Any?) : this() {
            this.status = status
            this.message = message
        }
    }

    private fun buildResponseEntity(apiError: ApiError): ResponseEntity<ApiError> {
        return ResponseEntity(apiError, apiError.status!!)
    }
}