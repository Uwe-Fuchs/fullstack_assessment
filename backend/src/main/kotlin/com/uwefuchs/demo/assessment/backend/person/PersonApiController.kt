package com.uwefuchs.demo.assessment.backend.person

import com.uwefuchs.demo.assessment.backend.color.Color
import com.uwefuchs.demo.assessment.helpers.PersonEntityDtoMapper
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
        val resultList = personService.findAllPersons()
            .stream()
            .map { PersonEntityDtoMapper.mapEntityToDto(it) }
            .toList()


        return if (resultList.isEmpty()) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND)
        } else {
            resultList
        }
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    fun findById(@PathVariable id: Int): Any? {
        return try {
            personService.findPersonById(id)
                .map { PersonEntityDtoMapper.mapEntityToDto(it) }
                .get()
        } catch (e: NoSuchElementException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND)
        }
    }

    @GetMapping("/color/{color}")
    @ResponseStatus(code = HttpStatus.OK)
    fun findByColor(@PathVariable color: Color): Any? {
        val resultList = personService.findPersonsByColor(color)
            .stream()
            .map { PersonEntityDtoMapper.mapEntityToDto(it) }
            .toList()

        return if (resultList.isEmpty()) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND)
        } else {
            resultList
        }
    }
}