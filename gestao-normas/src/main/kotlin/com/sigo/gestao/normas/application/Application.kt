package com.sigo.gestao.normas.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan


@SpringBootApplication
@ComponentScan(basePackages = ["com.sigo.gestao.normas"])
class Application

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}
