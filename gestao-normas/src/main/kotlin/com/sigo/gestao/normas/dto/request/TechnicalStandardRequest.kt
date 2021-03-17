package com.sigo.gestao.normas.dto.request

import java.io.Serializable

open class TechnicalStandardRequest (
        var name: String = "",
        var version: String = "",
        var validity: String = "",
        var iso: String = ""
) : Serializable