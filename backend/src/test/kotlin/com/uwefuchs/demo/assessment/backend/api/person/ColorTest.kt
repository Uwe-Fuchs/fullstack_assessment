package com.uwefuchs.demo.assessment.backend.api.person

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class ColorTest {
    @Test
    fun findColorById() {
        // given
        val colorId = 5

        // when
        val resultColor = Color.findColorById(colorId)

        // then
        Assertions.assertThat(resultColor).isEqualTo(Color.GELB)
    }

    @Test
    fun findColorById_noColor() {
        // given
        val unknownColorId = -1

        // when
        val resultColor = Color.findColorById(unknownColorId)

        // then
        Assertions.assertThat(resultColor).isNull()
    }

    @Test
    fun findColorByColorStr() {
        // given
        val colorStr = "gelb"

        // when
        val resultColor = Color.findColorByColorStr(colorStr)

        // then
        Assertions.assertThat(resultColor).isEqualTo(Color.GELB)
    }

    @Test
    fun findColorByColorStr_noColor() {
        // given
        val unknownColorStr = "unknownColorStr"

        // when
        val resultColor = Color.findColorByColorStr(unknownColorStr)

        // then
        Assertions.assertThat(resultColor).isNull()
    }
}