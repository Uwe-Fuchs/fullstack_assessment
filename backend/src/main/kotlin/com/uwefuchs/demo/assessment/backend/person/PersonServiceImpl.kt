package com.uwefuchs.demo.assessment.backend.person

import com.uwefuchs.demo.assessment.backend.color.Color
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import java.util.Optional

class PersonServiceImpl : PersonService {
    val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    @Qualifier("personRepository")
    lateinit var personRepository: PersonRepository

    override fun findAllPersons(): List<Person> {
        return emptyList()
    }

    override fun findPersonsByColor(color: Color): List<Person> {
        return emptyList()
    }

    override fun findPersonById(id: Int): Optional<Person> {
        TODO("Not yet implemented")
    }
}