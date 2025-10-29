package com.uwefuchs.demo.assessment.backend.helpers

import com.uwefuchs.demo.assessment.backend.api.person.Color
import com.uwefuchs.demo.assessment.backend.api.person.Person

object PersonEntityDtoMapper {
    fun mapEntityToDto(entity: Person): PersonDto {
        return PersonDto(
            entity.id,
            entity.name,
            entity.lastName,
            entity.zipCode,
            entity.city,
            entity.color?.colorStr)
    }

    fun mapDtoToEntity(dto: PersonDto): Person {
        return Person(
            dto.id,
            dto.name,
            dto.lastName,
            dto.zipCode,
            dto.city,
            Color.findColorByColorStr(dto.color ?: "")
        )
    }
}