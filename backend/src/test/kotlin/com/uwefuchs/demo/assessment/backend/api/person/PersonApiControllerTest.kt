package com.uwefuchs.demo.assessment.backend.api.person

import com.uwefuchs.demo.assessment.backend.api.person.helpers.PersonEntityDtoMapper
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any
import org.mockito.kotlin.eq
import org.mockito.kotlin.whenever
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.web.server.ResponseStatusException
import java.util.Optional


class PersonApiControllerTest {
    @Mock
    lateinit var personService: PersonService

    @InjectMocks
    lateinit var apiUnderTest: PersonApiController

    private var personsAsEntities = PersonTestsHelper.personsCache
    private var personsAsDtos = personsAsEntities.map { PersonEntityDtoMapper.mapEntityToDto(it) }

    @BeforeEach
    fun before() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun findAll() {
        // given
        whenever(personService.findAllPersons()).thenReturn(personsAsEntities)

        // when
        val resultList = apiUnderTest.findAll()

        // then
        assertThat(resultList).isEqualTo(personsAsDtos)
    }

    @Test
    fun findByPersonId() {
        // given
        whenever(personService.findPersonById(any())).thenReturn(Optional.of(personsAsEntities[9]))

        // when
        val resultPerson = apiUnderTest.findByPersonId(10)

        // then
        assertThat(resultPerson).isNotNull
        assertThat(resultPerson!!::class).isEqualTo(PersonDto::class)
        assertThat(resultPerson).isEqualTo(personsAsDtos[9])
    }

    @Test
    fun findByPersonId_invalidId() {
        // given
        val someInvalidPersonId = -1
        whenever(personService.findPersonById(any())).thenReturn(Optional.empty<Person>())

        // when
        val thrown: Throwable = catchThrowable {
            apiUnderTest.findByPersonId(someInvalidPersonId)
        }

        // then
        assertThat(thrown).isNotNull
        assertThat(thrown::class).isEqualTo(ResponseStatusException::class)
        assertThat((thrown as ResponseStatusException).statusCode).isEqualTo(HttpStatus.NOT_FOUND)
    }

    @Test
    fun findByColorId() {
        // given
        whenever(personService.findPersonsByColor(eq(Color.BLAU))).thenReturn(personsAsEntities.subList(2, 5))

        // when
        val resultList = apiUnderTest.findByColorId(Color.BLAU.colorId)

        // then
        assertThat(resultList).isNotNull
        assertThat(resultList!!::class).isEqualTo(ArrayList::class)
        assertThat(resultList as ArrayList<*>).hasSize(3)
        assertThat(resultList).isEqualTo(personsAsDtos.subList(2, 5))
    }

    @Test
    fun findByColorId_unknownColorId() {
        // given
        val someInvalidColorId = -1

        // when
        val thrown: Throwable = catchThrowable {
            apiUnderTest.findByColorId(someInvalidColorId)
        }

        // then
        assertThat(thrown).isNotNull
        assertThat(thrown::class).isEqualTo(ResponseStatusException::class)
        assertThat((thrown as ResponseStatusException).statusCode).isEqualTo(HttpStatus.BAD_REQUEST)
    }

    @Test
    fun findByColorId_noResults() {
        // given
        whenever(personService.findPersonsByColor(any())).thenReturn(emptyList<Person>())

        // when
        val resultList = apiUnderTest.findByColorId(Color.BLAU.colorId)

        // then
        assertThat(resultList).isNotNull
        assertThat(resultList!!::class).isEqualTo(ArrayList::class)
        assertThat(resultList as ArrayList<*>).isEmpty()
    }
}