package com.sigo.gestao.normas.config.token

import com.sigo.gestao.normas.dto.request.AuthRequest
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.util.DigestUtils
import java.util.Date

@Service
class TokenFactory {

    @Value("\${jwt.expiration.seconds}")
    var expirationTime: Long = 0

    @Value("\${jwt.secret}")
    var secret: String = ""

    fun create(authRequest: AuthRequest): String? {
        val now = Date()
        val expiresAt = Date(now.time + expirationTime * 1000)
        return Jwts
                .builder()
                .setIssuer("Sigo - Gestor de Normas")
                .setSubject(authRequest.username)
                .setIssuedAt(now)
                .setExpiration(expiresAt)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact()
    }
}