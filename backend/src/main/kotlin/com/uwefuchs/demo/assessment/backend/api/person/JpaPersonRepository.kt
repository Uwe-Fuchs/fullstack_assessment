package com.uwefuchs.demo.assessment.backend.api.person

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JpaPersonRepository : JpaRepository<Person, Int>, PersonRepository {
    override fun findByColor(color: Color): List<Person>
}