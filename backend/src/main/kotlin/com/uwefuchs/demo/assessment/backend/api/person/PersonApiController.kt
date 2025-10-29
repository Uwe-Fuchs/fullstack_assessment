package com.uwefuchs.demo.assessment.backend.api.person

import com.uwefuchs.demo.assessment.backend.api.person.helpers.PersonEntityDtoMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/persons")
class PersonApiController {
    @Autowired
    private lateinit var personService: PersonService

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    fun findAll(): Any? {
        return personService.findAllPersons()
            .map { PersonEntityDtoMapper.mapEntityToDto(it) }
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    fun findByPersonId(@PathVariable id: Int): Any? {
        return  personService.findPersonById(id)
            .map { PersonEntityDtoMapper.mapEntityToDto(it) }
            .orElseGet { null }  ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "No person found.")
    }

    @GetMapping("/color/{color}")
    @ResponseStatus(code = HttpStatus.OK)
    fun findByColorId(@PathVariable color: Int): Any? {
        val color = Color.findColorById(color) ?: return ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid color-id!")

        return personService.findPersonsByColor(color)
            .map { PersonEntityDtoMapper.mapEntityToDto(it) }
    }
}