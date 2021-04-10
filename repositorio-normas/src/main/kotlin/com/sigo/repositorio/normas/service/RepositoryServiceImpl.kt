package com.sigo.repositorio.normas.service

import com.sigo.gestao.normas.exception.TechnicalStandardNotFound
import com.sigo.repositorio.normas.model.TechnicalStandard
import org.springframework.stereotype.Service
import java.util.Optional
import java.util.UUID

@Service
internal class RepositoryServiceImpl : RepositoryService {

    private companion object {
        val standards: MutableList<TechnicalStandard> = mutableListOf()
    }

    override fun create(technicalStandard: TechnicalStandard): TechnicalStandard {
        standards.add(technicalStandard)
        return technicalStandard
    }

    override fun getById(id: UUID): TechnicalStandard {
        return Optional.ofNullable(standards.firstOrNull { it.id == id })
                .orElseThrow { TechnicalStandardNotFound("Technical Standard not found. Id: $id") }
    }

    override fun getAll(): List<TechnicalStandard> {
        return standards
    }

    override fun update(update: TechnicalStandard) {
        var technicalStandard = getById(update.id)
        technicalStandard.iso = update.iso
        technicalStandard.name = update.name
        technicalStandard.validity = update.validity
        technicalStandard.version = update.version
    }

    override fun delete(id: UUID) {
        standards.removeIf { it.id == id }
    }
}