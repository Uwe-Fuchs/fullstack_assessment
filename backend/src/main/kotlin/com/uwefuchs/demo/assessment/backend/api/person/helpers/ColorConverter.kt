package com.uwefuchs.demo.assessment.backend.api.person.helpers

import com.uwefuchs.demo.assessment.backend.api.person.Color
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter(autoApply = true)
class ColorConverter : AttributeConverter<Color, Int> {
    override fun convertToDatabaseColumn(color: Color?): Int? {
        return color?.colorId
    }

    override fun convertToEntityAttribute(colorId: Int?): Color? {
        if (colorId == null) {
            return null
        }

        return Color.Companion.findColorById(colorId)
    }
}