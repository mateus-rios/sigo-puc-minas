package com.sigo.gestao.normas.dto.request

import java.io.Serializable

data class AuthRequest(
        var username: String = "",
        var password: String = ""
) : Serializable {
}