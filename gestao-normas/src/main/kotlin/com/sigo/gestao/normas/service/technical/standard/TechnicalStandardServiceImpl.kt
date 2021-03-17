package com.sigo.gestao.normas.service.technical.standard

import com.sigo.gestao.normas.exception.TechnicalStandardNotFound
import com.sigo.gestao.normas.model.TechnicalStandard
import com.sigo.gestao.normas.service.notfier.KafkaNotifier
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Optional
import java.util.UUID

@Service
internal class TechnicalStandardServiceImpl
    @Autowired constructor(private val kafkaNotifier: KafkaNotifier): TechnicalStandardService {

    private companion object {
        val standards: MutableList<TechnicalStandard> = mutableListOf()
        const val TOPIC_NAME = "gestao_normas"
    }

    override fun create(technicalStandard: TechnicalStandard): TechnicalStandard {
        standards.add(technicalStandard)
        kafkaNotifier.notify(TOPIC_NAME, technicalStandard)
        return technicalStandard
    }

    override fun getById(id: UUID): TechnicalStandard {
       return Optional.ofNullable(standards.firstOrNull { it.id == id })
               .orElseThrow { TechnicalStandardNotFound("Technical Standard not found. Id: $id") }
    }

    override fun getAll(): List<TechnicalStandard> {
        return standards
    }
}