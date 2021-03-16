package com.sigo.gestao.normas.model

import java.io.Serializable
import java.util.UUID


data class TechnicalStandard (
        var name: String = "",
        var version: String = "",
        var validity: String = "",
        var iso: String = "",
        override var id: UUID = UUID.randomUUID()
) : DefaultData