package com.uwefuchs.demo.assecor_assessment.assecor_assessment.backend.person

import com.uwefuchs.demo.assecor_assessment.assecor_assessment.backend.color.Color
import java.util.Optional

interface PersonService {
    fun findAllPersons(): List<Person>

    fun findPersonsByColor(color: Color): List<Person>

    fun findPersonById(id: Int): Optional<Person>
}