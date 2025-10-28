package com.uwefuchs.demo.assecor_assessment.assecor_assessment.backend.person

import com.uwefuchs.demo.assecor_assessment.assecor_assessment.backend.color.Color
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.Optional

@Component
class InMemoryPersonRepository : PersonRepository {
    val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    lateinit var personsDataCache: List<Person>

    override fun findAll(): Iterable<Person> {
        return emptyList()
    }

    override fun findByColor(color: Color): Iterable<Person> {
        return emptyList()
    }

    override fun findById(id: Int): Optional<Person>? {
        TODO("Not yet implemented")
    }
}