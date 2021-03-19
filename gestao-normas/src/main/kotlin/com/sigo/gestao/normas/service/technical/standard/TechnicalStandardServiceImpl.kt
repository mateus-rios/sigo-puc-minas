package com.sigo.gestao.normas.service.technical.standard

import com.sigo.gestao.normas.exception.TechnicalStandardNotFound
import com.sigo.gestao.normas.model.TechnicalStandard
import com.sigo.gestao.normas.service.notfier.KafkaNotifier
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import org.springframework.web.client.postForObject
import java.lang.reflect.ParameterizedType
import java.util.Optional
import java.util.UUID

@Service
internal class TechnicalStandardServiceImpl
@Autowired constructor(
        private val kafkaNotifier: KafkaNotifier,
        restTemplateBuilder: RestTemplateBuilder
) : TechnicalStandardService {

    private companion object {
        const val TOPIC_NAME = "gestao_normas"
    }

    @Value("\${repositorio.normas.url}")
    private lateinit var urlRepositorioNormas: String

    private val restTemplate: RestTemplate = restTemplateBuilder.build()

    override fun create(technicalStandard: TechnicalStandard): TechnicalStandard {
        restTemplate.postForObject(urlRepositorioNormas, technicalStandard, Map::class.java)
        kafkaNotifier.notify(TOPIC_NAME, technicalStandard)
        return technicalStandard
    }

    override fun getById(id: UUID): TechnicalStandard {
        val response = restTemplate.getForEntity("$urlRepositorioNormas/$id", TechnicalStandard::class.java)
        if (response.statusCode == HttpStatus.NOT_FOUND) {
            throw TechnicalStandardNotFound("Technical Standard not found. Id: $id")
        }
        return response.body!!
    }

    override fun getAll(): List<TechnicalStandard> {
        val response = restTemplate.exchange("$urlRepositorioNormas/all", HttpMethod.GET, null, object : ParameterizedTypeReference<List<TechnicalStandard>>() {})
        return response.body!!
    }
}