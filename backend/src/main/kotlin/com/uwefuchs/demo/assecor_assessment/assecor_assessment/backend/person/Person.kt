package com.uwefuchs.demo.assecor_assessment.assecor_assessment.backend.person

import com.uwefuchs.demo.assecor_assessment.assecor_assessment.backend.color.Color
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "person")
data class Person (
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column
    val name: String,

    @Column(name = "last_name")
    val lastName: String,

    @Column(name = "zip_code")
    val zipCode: String,

    @Column
    val city: String,

    @Column
    val color: Color?
)