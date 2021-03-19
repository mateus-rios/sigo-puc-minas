package com.sigo.repositorio.normas.service

import com.sigo.repositorio.normas.model.TechnicalStandard
import java.util.UUID

interface RepositoryService {

    fun create(technicalStandard: TechnicalStandard): TechnicalStandard
    fun getById(id: UUID): TechnicalStandard
    fun getAll(): List<TechnicalStandard>
}