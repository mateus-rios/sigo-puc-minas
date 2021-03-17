package com.sigo.gestao.normas.dto.response

import com.sigo.gestao.normas.dto.request.TechnicalStandardRequest
import java.util.*

class TechnicalStandardResponse(
        name: String,
        version: String,
        validity: String,
        iso: String,
        var id: UUID = UUID.randomUUID()
) : TechnicalStandardRequest(
        name, version, validity, iso
)