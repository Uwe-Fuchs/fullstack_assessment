package com.uwefuchs.demo.assessment.helpers

import com.uwefuchs.demo.assessment.backend.color.Color
import com.uwefuchs.demo.assessment.backend.person.Person
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.core.io.Resource

object PersonsCreator {
    val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    fun createPersonDataCache(dataResource: Resource): List<Person> {
        require(dataResource.exists()) { "dataResource not found!" }
        val personList = createPersonsList(dataResource)
        logger.info("persons-data successfully created: {}", personList)

        return personList
    }

    private fun createPersonsList(dataResource: Resource): List<Person> {
        logger.debug("Start importing persons-data file ...")

        val inputStream = dataResource.inputStream
        val reader = inputStream.bufferedReader()

        var counter = 1
        val resultList =  reader.lineSequence()
            .filter { it.isNotBlank() }
            .filter { item -> item.split(",").size == 4 }
            .map {
                var (lastName, name, zipCode_city, colorStr) = it.split(",", ignoreCase = false, limit = 4)
                if (colorStr == "")  colorStr = "-1"
                val (zipCode, city) = zipCode_city.trim().split(" ", ignoreCase = false, limit = 2)
                Person(
                    counter++,
                    name.trim(),
                    lastName.trim(),
                    zipCode.trim(),
                    city.trim(),
                    Color.findColorById(colorStr.trim().toInt())
                )
            }.toList()

        logger.debug("... success! PersonsList: {}", resultList)

        return resultList
    }
}