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
    fun findByPersonId(@PathVariable(required=true) id: Int): Any? {
        val resultPerson = personService.findPersonById(id)

        if (resultPerson.isPresent) {
            return PersonEntityDtoMapper.mapEntityToDto(resultPerson.get())
        } else {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "No person found.")
        }
    }

    @GetMapping("/color/{color}")
    @ResponseStatus(code = HttpStatus.OK)
    fun findByColorId(@PathVariable(name="color", required=true) colorId: Int): Any? {
        val color = Color.findColorById(colorId) ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid color-id!")

        return personService.findPersonsByColor(color)
            .map { PersonEntityDtoMapper.mapEntityToDto(it) }
    }
}