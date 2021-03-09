package com.sigo.gestao.normas.controller

import com.sigo.gestao.normas.dto.request.TechnicalStandardRequest
import com.sigo.gestao.normas.dto.response.TechnicalStandardResponse
import com.sigo.gestao.normas.exception.TechnicalStandardNotFound
import org.apache.tomcat.util.http.parser.HttpParser
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.util.*
import javax.validation.Valid

@RestController()
@RequestMapping("/normas")
class GestaoNormasController {

    companion object {
        val standards: MutableList<TechnicalStandardResponse> = mutableListOf()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid technicalStandardRequest: TechnicalStandardRequest): ResponseEntity.BodyBuilder {
        val createdEntity = TechnicalStandardResponse(
                technicalStandardRequest.name,
                technicalStandardRequest.version,
                technicalStandardRequest.validity,
                technicalStandardRequest.iso
        )
        standards.add(createdEntity)
        val location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdEntity.id)
                .toUri()

        return ResponseEntity.created(location)
    }

    @GetMapping("/{id}")
    fun getById( @PathVariable id: UUID): TechnicalStandardResponse {
        return Optional.ofNullable(standards.firstOrNull { it.id == id })
                .orElseThrow { TechnicalStandardNotFound("Technical Standard not found. Id: $id") }
    }

    @GetMapping("/all")
    fun getAll(): List<TechnicalStandardResponse> {
        return standards
    }


}