package com.uwefuchs.demo.assecor_assessment.assecor_assessment.backend.person

import com.uwefuchs.demo.assecor_assessment.assecor_assessment.backend.color.Color

data class Person (
    val id: Int,
    val name: String,
    val lastName: String,
    val zipCode: String,
    val city: String,
    val color: Color?
)