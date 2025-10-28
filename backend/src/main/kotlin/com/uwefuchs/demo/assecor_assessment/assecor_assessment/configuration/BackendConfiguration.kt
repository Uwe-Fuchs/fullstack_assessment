package com.uwefuchs.demo.assecor_assessment.assecor_assessment.configuration

import com.uwefuchs.demo.assecor_assessment.assecor_assessment.backend.person.InMemoryPersonRepository
import com.uwefuchs.demo.assecor_assessment.assecor_assessment.backend.person.PersonRepository
import com.uwefuchs.demo.assecor_assessment.assecor_assessment.helpers.PersonsCreator
import jakarta.annotation.PostConstruct
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.FileSystemResourceLoader

@Configuration
class BackendConfiguration {
    val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @Value("\${person.path_to_data_file}")
    lateinit var pathToDatafile: String

    @Autowired
    @Qualifier("inMemoryPersonRepository")
    lateinit var personRepository: PersonRepository

    @PostConstruct
    fun init() {
        val resource = FileSystemResourceLoader().getResource("file:${pathToDatafile}")
        (personRepository as InMemoryPersonRepository).personsDataCache =
            PersonsCreator.createPersonDataCache(resource)
        logger.debug("personsDataCache: {}", (personRepository as InMemoryPersonRepository).personsDataCache)
    }
}