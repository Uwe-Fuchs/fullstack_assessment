package com.uwefuchs.demo.assessment.backend.configuration

import com.uwefuchs.demo.assessment.backend.api.person.helpers.PersonsCreator
import com.uwefuchs.demo.assessment.backend.api.person.InMemoryPersonRepository
import com.uwefuchs.demo.assessment.backend.api.person.PersonRepository
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
            personRepository.personsCache = PersonsCreator.createPersonDataCache(resource)

            return personRepository
        }
    }
}