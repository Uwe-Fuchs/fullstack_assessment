package com.uwefuchs.demo.assessment.helpers

import com.fasterxml.jackson.annotation.JsonProperty

data class PersonDto(
    val id: Int,
    val name: String,

    @get:JsonProperty("lastname")
    val lastName: String,

    @get:JsonProperty("zipcode")
    val zipCode: String,

    val city: String,
    val color: String
)