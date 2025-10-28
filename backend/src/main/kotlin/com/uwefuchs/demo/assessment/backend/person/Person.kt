package com.uwefuchs.demo.assessment.backend.person

import com.uwefuchs.demo.assessment.backend.color.Color
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

    @Column(name = "lastname")
    val lastName: String,

    @Column(name = "zipcode")
    val zipCode: String,

    @Column
    val city: String,

    @Column
    val color: Color?
)