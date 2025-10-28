package com.uwefuchs.demo.assessment.helpers

import com.uwefuchs.demo.assessment.backend.color.Color
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.core.io.ClassPathResource

class PersonsCreatorTest {
    @Test
    fun createPersonDataCache() {
        // given
        val sampleDataResource = ClassPathResource("/sample-input.csv")

        // when
        val resultList = PersonsCreator.createPersonDataCache(sampleDataResource)

        // then
        Assertions.assertThat(resultList).hasSize(5)

        Assertions.assertThat(resultList[0].color).isEqualTo(Color.BLAU)
        Assertions.assertThat(resultList[1].color).isEqualTo(Color.VIOLETT)
        Assertions.assertThat(resultList[2].color).isEqualTo(Color.ROT)
        Assertions.assertThat(resultList[3].color).isEqualTo(Color.GRUEN)
        Assertions.assertThat(resultList[4].color).isNull()

        Assertions.assertThat(resultList[0].zipCode).isEqualTo("67742")
        Assertions.assertThat(resultList[0].city).isEqualTo("Lauterecken")
        Assertions.assertThat(resultList[1].city).isEqualTo("made up")
        Assertions.assertThat(resultList[2].city).isEqualTo("made up too")
        Assertions.assertThat(resultList[3].city).isEqualTo("Schweden - ☀")
    }

    @Test
    fun createPersonDataCache_invalidEntries() {
        // given
        val sampleDataResource = ClassPathResource("/sample-input_invalid_entries.csv")

        // when
        val resultList = PersonsCreator.createPersonDataCache(sampleDataResource)

        // then
        Assertions.assertThat(resultList).isEmpty()
    }
}