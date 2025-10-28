package com.uwefuchs.demo.assessment.backend.person

import com.uwefuchs.demo.assessment.backend.color.Color
import java.util.Optional

interface PersonRepository {
    fun findAll(): List<Person>

    fun findByColor(color: Color): List<Person>

    fun findById(id: Int): Optional<Person>?
}