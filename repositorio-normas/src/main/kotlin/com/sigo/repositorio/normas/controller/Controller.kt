package com.sigo.repositorio.normas.controller

import com.sigo.gestao.normas.dto.request.TechnicalStandardRequest
import com.sigo.gestao.normas.dto.response.TechnicalStandardResponse
import com.sigo.repositorio.normas.model.TechnicalStandard
import com.sigo.repositorio.normas.service.RepositoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.util.UUID
import javax.validation.Valid

@RestController
class Controller @Autowired constructor(
        private val repositoryService: RepositoryService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(
            @RequestBody @Valid technicalStandardRequest: TechnicalStandardRequest,
            uriComponentsBuilder: ServletUriComponentsBuilder
    ): ResponseEntity<TechnicalStandardResponse> {
        val model = TechnicalStandard(
                technicalStandardRequest.name,
                technicalStandardRequest.version,
                technicalStandardRequest.validity,
                technicalStandardRequest.iso
        )

        val created = repositoryService.create(model)
        val location = uriComponentsBuilder
                .path("/{id}")
                .buildAndExpand(created.id)
                .toUri()

        val (name, version, validity, iso, id) = created
        return ResponseEntity.created(location).body(TechnicalStandardResponse(
                name, version, validity, iso, id
        ))
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: UUID): TechnicalStandardResponse {
        val (name, version, validity, iso, id) = repositoryService.getById(id)
        return TechnicalStandardResponse(
                name, version, validity, iso, id
        )
    }

    @GetMapping("/all")
    fun getAll(): List<TechnicalStandardResponse> {
        return repositoryService.getAll().map {
            val (name, version, validity, iso, id) = it
            TechnicalStandardResponse(name, version, validity, iso, id)
        }
    }
}