package com.sigo.gestao.normas.config.token

interface TokenService {

    fun validAndAuthenticate(token: String?): Boolean
}