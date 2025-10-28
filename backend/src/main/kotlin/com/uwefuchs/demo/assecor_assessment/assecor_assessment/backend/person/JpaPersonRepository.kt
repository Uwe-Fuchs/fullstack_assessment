package com.uwefuchs.demo.assecor_assessment.assecor_assessment.backend.person

import com.uwefuchs.demo.assecor_assessment.assecor_assessment.backend.color.Color
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JpaPersonRepository : JpaRepository<Person, Int>, PersonRepository {
    override fun findByColor(color: Color): List<Person>
}