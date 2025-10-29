package com.uwefuchs.demo.assessment.backend.api.person

import java.util.Optional

interface PersonService {
    fun findAllPersons(): List<Person>

    fun findPersonsByColor(color: Color): List<Person>

    fun findPersonById(id: Int): Optional<Person>
}