package com.sigo.gestao.normas.dto.request

import java.io.Serializable
import javax.validation.constraints.NotBlank

data class AuthRequest(

        @field:NotBlank(message = "Por favor informe o nome do usuário")
        var username: String = "",

        @field:NotBlank(message = "Por favor informe a senha")
        var password: String = ""
) : Serializable