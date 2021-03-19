package com.sigo.repositorio.normas.model

import java.util.UUID


data class TechnicalStandard (
        var name: String = "",
        var version: String = "",
        var validity: String = "",
        var iso: String = "",
        var id: UUID = UUID.randomUUID()
)