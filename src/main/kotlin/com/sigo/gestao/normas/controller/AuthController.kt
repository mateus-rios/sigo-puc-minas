package com.sigo.gestao.normas.controller

import com.sigo.gestao.normas.config.token.TokenFactory
import com.sigo.gestao.normas.dto.request.AuthRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class AuthController @Autowired constructor(
        private val tokenFactory: TokenFactory
) {

    @PostMapping("/auth")
    fun authorize(@RequestBody @Valid authRequest: AuthRequest): ResponseEntity<Any> {
        val token = tokenFactory.create(authRequest)
        return ResponseEntity.ok().body(hashMapOf("type" to "Bearer", "token" to token));
    }
}