package com.sigo.gestao.normas.service.notfier

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.postForObject

@Service
internal class KafkaNotifierImpl
    @Autowired constructor(restTemplateBuilder: RestTemplateBuilder): KafkaNotifier {

    private val restTemplate: RestTemplate = restTemplateBuilder.build()

    @Value("\${kafka.rest.topics.url}")
    private lateinit var kafkaTopicsUrl: String

    private companion object {
        val headers = HttpHeaders()
    }

    init {
        headers.set("Content-Type", "application/vnd.kafka.json.v1+json")
    }

    override fun notify(topicName: String, data: Any) {
        val body = KafkaRequest()
        body.addRecord(data)
        val request = HttpEntity<Any>(body, headers)
        val response = restTemplate.postForObject("$kafkaTopicsUrl/$topicName", request, Map::class.java)
        println(response)
    }
}