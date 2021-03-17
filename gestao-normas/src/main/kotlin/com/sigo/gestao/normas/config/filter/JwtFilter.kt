package com.sigo.gestao.normas.config.filter

import com.sigo.gestao.normas.config.token.TokenService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Configuration
class JwtFilter @Autowired constructor(
        private val tokenService: TokenService
): OncePerRequestFilter() {


    override fun doFilterInternal(req: HttpServletRequest, res: HttpServletResponse, filterChain: FilterChain) {

        var authorization: String? = null
        req.getHeader("Authorization")
                ?.let {
                    if(it.isEmpty() || !it.startsWith("Bearer")){
                        authorization = null
                        return@let
                    }
                    authorization = it.split(" ")[1]
                }
        tokenService.validAndAuthenticate(authorization)

        filterChain.doFilter(req, res)
    }
}