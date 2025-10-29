package com.uwefuchs.demo.assessment.backend.api.person.helpers

import com.uwefuchs.demo.assessment.backend.api.person.Color
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ColorConverterTest {
    private lateinit var converterUnderTest: ColorConverter

    @BeforeEach
    fun setUp() {
        converterUnderTest = ColorConverter()
    }

            @Test
    fun convertToDatabaseColumn() {
        // given
        val color = Color.TUERKIS

        // when
        val resultColor = converterUnderTest.convertToDatabaseColumn(color)

        // then
        assertThat(resultColor).isEqualTo(color.colorId)
    }

    @Test
    fun convertToDatabaseColumn_nullColor() {
        // given when
        val resultColor = converterUnderTest.convertToDatabaseColumn(null)

        // then
        assertThat(resultColor).isNull()
    }

    @Test
    fun convertToEntityAttribute() {
        // given
        val databaseColor = 2

        // when
        val resultColor = converterUnderTest.convertToEntityAttribute(databaseColor)

        // then
        assertThat(resultColor).isEqualTo(Color.findColorById(databaseColor))
    }

    @Test
    fun convertToEntityAttribute_nullColor() {
        // given when
        val resultColor = converterUnderTest.convertToEntityAttribute(null)

        // then
        assertThat(resultColor).isNull()
    }

    @Test
    fun convertToEntityAttribute_invalidColorId() {
        // given
        val invalidColorId = -2

        // when
        val resultColor = converterUnderTest.convertToEntityAttribute(invalidColorId)

        // then
        assertThat(resultColor).isNull()
    }
}