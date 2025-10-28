package com.uwefuchs.demo.assecor_assessment.assecor_assessment.backend.color

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class ColorTest {
    @Test
    fun findColorById() {
        // given
        val colorId = 5

        // when
        val resultColor = Color.findColorById(colorId)

        // then
        assertThat(resultColor).isEqualTo(Color.GELB)
    }

    @Test
    fun findColorById_noColor() {
        // given
        val unknownColorId = -1

        // when
        val resultColor = Color.findColorById(unknownColorId)

        // then
        assertThat(resultColor).isNull()
    }

    @Test
    fun findColorByColorStr() {
        // given
        val colorStr = "gelb"

        // when
        val resultColor = Color.findColorByColorStr(colorStr)

        // then
        assertThat(resultColor).isEqualTo(Color.GELB)
    }

    @Test
    fun findColorByColorStr_noColor() {
        // given
        val unknownColorStr = "unknownColorStr"

        // when
        val resultColor = Color.findColorByColorStr(unknownColorStr)

        // then
        assertThat(resultColor).isNull()
    }
}