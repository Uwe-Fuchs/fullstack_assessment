package com.uwefuchs.demo.assecor_assessment.assecor_assessment.helpers

import com.uwefuchs.demo.assecor_assessment.assecor_assessment.backend.color.Color
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.springframework.core.io.ClassPathResource

class PersonsCreatorTest {
    @Test
    fun createPersonDataCache() {
        // given
        val sampleDataResource = ClassPathResource("/sample-input.csv")

        // when
        val resultList = PersonsCreator.createPersonDataCache(sampleDataResource)

        // then
        assertThat(resultList).hasSize(5)

        assertThat(resultList[0].color).isEqualTo(Color.BLAU)
        assertThat(resultList[1].color).isEqualTo(Color.VIOLETT)
        assertThat(resultList[2].color).isEqualTo(Color.ROT)
        assertThat(resultList[3].color).isEqualTo(Color.GRUEN)
        assertThat(resultList[4].color).isNull()

        assertThat(resultList[0].zipCode).isEqualTo("67742")
        assertThat(resultList[0].city).isEqualTo("Lauterecken")
        assertThat(resultList[1].city).isEqualTo("made up")
        assertThat(resultList[2].city).isEqualTo("made up too")
        assertThat(resultList[3].city).isEqualTo("Schweden - ☀")
    }

    @Test
    fun createPersonDataCache_invalidEntries() {
        // given
        val sampleDataResource = ClassPathResource("/sample-input_invalid_entries.csv")

        // when
        val resultList = PersonsCreator.createPersonDataCache(sampleDataResource)

        // then
        assertThat(resultList).isEmpty()
    }
}