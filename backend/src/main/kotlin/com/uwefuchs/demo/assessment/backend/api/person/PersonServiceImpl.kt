package com.uwefuchs.demo.assessment.backend.api.person

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class PersonServiceImpl : PersonService {
    val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    @Qualifier("personRepository")
    lateinit var personRepository: PersonRepository

    override fun findAllPersons(): List<Person> {
        return personRepository.findAll()
    }

    override fun findPersonsByColor(color: Color): List<Person> {
        return personRepository.findByColor(color)
    }

    override fun findPersonById(id: Int): Optional<Person> {
        return  personRepository.findById(id)
    }
}