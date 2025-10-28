package com.uwefuchs.demo.assessment.backend.person

import com.uwefuchs.demo.assessment.backend.color.Color
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class InMemoryPersonRepositoryTest {
    private lateinit var repoUnderTest: InMemoryPersonRepository

    @BeforeEach
    fun setUp() {
        repoUnderTest = InMemoryPersonRepository()
        repoUnderTest.personsCache = this.personsCache
    }

    @Test
    fun findAll() {
        // given when
        val resultSet = repoUnderTest.findAll()

        // then
        assertThat(resultSet).isEqualTo(personsCache)
    }

    @Test
    fun findByColor() {
        // given
        val givenColor = Color.GRUEN

        // when
        val resultSet = repoUnderTest.findByColor(givenColor)

        // then
        assertThat(resultSet).hasSize(3)
        assertThat(resultSet).containsExactlyInAnyOrder(personsCache[1], personsCache[6], personsCache[8])
    }

    @Test
    fun findByColor_noResults() {
        // given
        val givenColor = Color.WEISS

        // when
        val resultSet = repoUnderTest.findByColor(givenColor)

        // then
        assertThat(resultSet).isEmpty()
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

    private val personsCache=listOf(
        Person(id=1, lastName="Müller", name="Hans", zipCode="67742", city="Lauterecken", color=Color.findColorById(1)),
        Person(id=2, lastName="Petersen", name="Peter", zipCode="18439", city="Stralsund", color=Color.findColorById(2)),
        Person(id=3, lastName="Johnson", name="Johnny", zipCode="88888", city="made up", color=Color.findColorById(3)),
        Person(id=4, lastName="Millenium", name="Milly", zipCode="77777", city="made up too", color=Color.findColorById(4)),
        Person(id=5, lastName="Müller", name="Jonas", zipCode="32323", city="Hansstadt", color=Color.findColorById(5)),
        Person(id=6, lastName="Fujitsu", name="Tastatur", zipCode="42342", city="Japan", color=Color.findColorById(6)),
        Person(id=7, lastName="Andersson", name="Anders", zipCode="32132", city="Schweden", color=Color.findColorById(2)),
        Person(id=8, lastName="Gerber", name="Gerda", zipCode="76535", city="Woanders", color=Color.findColorById(3)),
        Person(id=9, lastName="Klaussen", name="Klaus", zipCode="43246", city="Hierach", color=Color.findColorById(2)),
        Person(id=10, lastName="Fuchs", name="Uwe", zipCode="22765", city="Hamburg", color=null),
    )
}