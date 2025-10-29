package com.uwefuchs.demo.assessment.backend.api.person

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class PersonEntityDtoMapperTest {
    @Test
    fun mapEntityToDto() {
        // given when
        val resultDto = PersonEntityDtoMapper.mapEntityToDto(personEntity)

        // then
        Assertions.assertThat(resultDto).isEqualTo(personDto)
    }

    @Test
    fun mapEntityToDto_noColor() {
        // given when
        val resultDto = PersonEntityDtoMapper.mapEntityToDto(personEntityNoColor)

        // then
        Assertions.assertThat(resultDto.color).isNull()
    }

    @Test
    fun mapDtoToEntity() {
        // given when
        val resultEntity = PersonEntityDtoMapper.mapDtoToEntity(personDto)

        // then
        Assertions.assertThat(resultEntity).isEqualTo(personEntity)
    }

    @Test
    fun mapDtoToEntity_noColor() {
        // given when
        val resultEntity = PersonEntityDtoMapper.mapDtoToEntity(personDtoNoColor)

        // then
        Assertions.assertThat(resultEntity.color).isNull()
    }

    private val personEntity = Person(
        1,
        "name",
        "lastName",
        "zipCode",
        "city",
        Color.BLAU
    )

    private val personEntityNoColor = Person(
        2,
        "name_2",
        "lastName_2",
        "zipCode_2",
        "city_2",
        null
    )

    private val personDto = PersonDto(
        id = 1,
        "name",
        "lastName",
        "zipCode",
        "city",
        "blau"
    )

    private val personDtoNoColor = PersonDto(
        2,
        "name_2",
        "lastName_2",
        "zipCode_2",
        "city_2",
        null
    )
}