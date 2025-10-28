package com.uwefuchs.demo.assecor_assessment.assecor_assessment.configuration

import com.uwefuchs.demo.assecor_assessment.assecor_assessment.backend.person.InMemoryPersonRepository
import com.uwefuchs.demo.assecor_assessment.assecor_assessment.backend.person.PersonRepository
import com.uwefuchs.demo.assecor_assessment.assecor_assessment.helpers.PersonsCreator
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.FileSystemResourceLoader

@Configuration
class BackendConfiguration {
    val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @Value("\${person.path_to_data_file}")
    var pathToDatafile: String? = null

    @Value("\${person.repository.type.database}")
    var personRepositoryTypeDatabase: Boolean = false

    @Autowired
    var jpaPersonRepository: PersonRepository? = null

    @Bean
    fun personRepository(): PersonRepository {
        if (personRepositoryTypeDatabase) {
            return jpaPersonRepository!!
        } else {
            val personRepository = InMemoryPersonRepository()
            val resource = FileSystemResourceLoader().getResource("file:${pathToDatafile}")
            personRepository.personsDataCache = PersonsCreator.createPersonDataCache(resource)

            return personRepository
        }
    }
}