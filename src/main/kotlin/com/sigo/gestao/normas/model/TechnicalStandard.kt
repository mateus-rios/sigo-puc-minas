package com.sigo.gestao.normas.model

import java.io.Serializable
import java.util.UUID


data class TechnicalStandard (
        var name: String = "",
        var version: String = "",
        var validity: String = "",
        var iso: String = "",
        var id: UUID = UUID.randomUUID()
) : Serializable