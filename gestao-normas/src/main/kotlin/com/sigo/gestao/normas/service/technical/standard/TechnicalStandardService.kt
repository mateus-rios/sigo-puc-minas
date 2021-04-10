package com.sigo.gestao.normas.service.technical.standard

import com.sigo.gestao.normas.model.TechnicalStandard
import java.util.UUID

interface TechnicalStandardService {
    fun create(technicalStandard: TechnicalStandard): TechnicalStandard
    fun getById(id: UUID): TechnicalStandard
    fun getAll(): List<TechnicalStandard>
    fun update(technicalStandard: TechnicalStandard): TechnicalStandard
    fun delete(id: UUID)
}