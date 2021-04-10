package com.sigo.gestao.normas.controller

import com.sigo.gestao.normas.config.token.TokenFactory
import com.sigo.gestao.normas.dto.request.AuthRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid
import javax.validation.constraints.NotNull

@RestController
class AuthController @Autowired constructor(
        private val tokenFactory: TokenFactory,
        private val authManager: AuthenticationManager
) {

    @PostMapping("/auth")
    fun authorize(@RequestBody @Valid  @NotNull authRequest: AuthRequest): ResponseEntity<Any> {
        return try {
            authManager.authenticate(UsernamePasswordAuthenticationToken(authRequest.username, authRequest.password))
            val token = tokenFactory.create(authRequest)
            return ResponseEntity.ok().body(hashMapOf("type" to "Bearer", "token" to token))
        } catch(e: Exception) {
            ResponseEntity.badRequest().body(mapOf("mensagem" to "Usuário ou senha inválidos"))
        }

    }
}