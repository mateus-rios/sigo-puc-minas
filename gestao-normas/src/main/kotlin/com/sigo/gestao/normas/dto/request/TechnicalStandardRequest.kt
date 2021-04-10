package com.sigo.gestao.normas.dto.request

import java.io.Serializable
import javax.validation.constraints.NotBlank

open class TechnicalStandardRequest (

        @field:NotBlank(message = "Por favor informe o nome da norma")
        var name: String = "",

        @field:NotBlank(message = "Por favor informe a versão da norma")
        var version: String = "",

        @field:NotBlank(message = "Por favor informe a validade da norma")
        var validity: String = "",

        var iso: String = ""
) : Serializable