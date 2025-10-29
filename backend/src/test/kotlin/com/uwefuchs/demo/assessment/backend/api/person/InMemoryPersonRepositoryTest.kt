package com.uwefuchs.demo.assessment.backend.api.person

import com.uwefuchs.demo.assessment.backend.api.person.PersonTestsHelper.personsCache
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class InMemoryPersonRepositoryTest {
    private lateinit var repoUnderTest: InMemoryPersonRepository

    @BeforeEach
    fun setUp() {
        repoUnderTest = InMemoryPersonRepository()
        repoUnderTest.personsCache = personsCache
    }

    @Test
    fun findAll() {
        // given when
        val resultList = repoUnderTest.findAll()

        // then
        assertThat(resultList).isEqualTo(personsCache)
    }

    @Test
    fun findByColor() {
        // given
        val givenColor = Color.GRUEN

        // when
        val resultList = repoUnderTest.findByColor(givenColor)

        // then
        assertThat(resultList).hasSize(3)
        assertThat(resultList).containsExactlyInAnyOrder(personsCache[1], personsCache[6], personsCache[8])
    }

    @Test
    fun findByColor_noResults() {
        // given
        val givenColor = Color.WEISS

        // when
        val resultList = repoUnderTest.findByColor(givenColor)

        // then
        assertThat(resultList).isEmpty()
    }

    @Test
    fun findById() {
        // given
        val existingId = 10

        // when
        val result = repoUnderTest.findById(existingId)

        // then
        assertThat(result).isPresent
        assertThat(result.get()).isEqualTo(personsCache[9])
    }

    @Test
    fun findById_noResult() {
        // given
        val nonExistingId = -1

        // when
        val result = repoUnderTest.findById(nonExistingId)

        // then
        assertThat(result).isNotPresent
    }
}