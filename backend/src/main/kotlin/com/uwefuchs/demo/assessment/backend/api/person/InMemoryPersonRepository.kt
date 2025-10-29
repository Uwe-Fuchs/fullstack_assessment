package com.uwefuchs.demo.assessment.backend.api.person

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.Optional

class InMemoryPersonRepository : PersonRepository {
    val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    lateinit var personsCache: List<Person>

    override fun findAll(): List<Person> {
        return personsCache
    }

    override fun findByColor(color: Color): List<Person> {
        return personsCache
            .stream()
            .filter { it.color == color }
            .toList()
    }

    override fun findById(id: Int): Optional<Person> {
        return personsCache
            .stream()
            .filter { it.id == id }
            .findFirst()
    }
}