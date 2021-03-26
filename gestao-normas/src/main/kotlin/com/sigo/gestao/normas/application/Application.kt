package com.sigo.gestao.normas.application

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.client.RestTemplate


@SpringBootApplication
@ComponentScan(basePackages = ["com.sigo.gestao.normas"])
class Application {

	@Value("\${repositorio.normas.user}")
	private lateinit var userRepositorioNormas: String

	@Value("\${repositorio.normas.password}")
	private lateinit var passwordRepositorioNormas: String

	@Bean
	fun restTemplate(restTemplateBuilder: RestTemplateBuilder): RestTemplate? {
		return restTemplateBuilder.basicAuthentication(userRepositorioNormas, passwordRepositorioNormas).build()
	}
}

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}
