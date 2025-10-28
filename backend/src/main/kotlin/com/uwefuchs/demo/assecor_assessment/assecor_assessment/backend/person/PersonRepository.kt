package com.uwefuchs.demo.assecor_assessment.assecor_assessment.backend.person

import com.uwefuchs.demo.assecor_assessment.assecor_assessment.backend.color.Color
import java.util.Optional

interface PersonRepository {
    fun findAll(): List<Person>

    fun findByColor(color: Color): List<Person>

    fun findById(id: Int): Optional<Person>?
}