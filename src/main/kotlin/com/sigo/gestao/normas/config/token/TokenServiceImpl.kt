package com.sigo.gestao.normas.config.token

import io.jsonwebtoken.Jwts
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
internal class TokenServiceImpl : TokenService {

    @Value("\${jwt.secret}")
    private lateinit var secretKey: String

    override fun validAndAuthenticate(token: String?): Boolean {
        return try {
            val claimsJws = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).body
            val usernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken(claimsJws.subject, null, null)
            SecurityContextHolder.getContext().authentication = usernamePasswordAuthenticationToken
            true
        } catch (e: Exception) {
            false
        }

    }
}