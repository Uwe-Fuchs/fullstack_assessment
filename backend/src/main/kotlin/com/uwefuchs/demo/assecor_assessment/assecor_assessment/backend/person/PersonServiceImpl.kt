package com.uwefuchs.demo.assecor_assessment.assecor_assessment.backend.person

import com.uwefuchs.demo.assecor_assessment.assecor_assessment.backend.color.Color
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import java.util.Optional

class PersonServiceImpl : PersonService {
    val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @Autowired
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