package com.uwefuchs.demo.assessment.backend.api.person

import java.util.Optional

interface PersonRepository {
    fun findAll(): List<Person>

    fun findByColor(color: Color): List<Person>

    fun findById(id: Int): Optional<Person>
}