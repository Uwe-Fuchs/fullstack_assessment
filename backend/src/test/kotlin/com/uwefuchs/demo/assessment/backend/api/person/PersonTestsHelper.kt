package com.uwefuchs.demo.assessment.backend.api.person

object PersonTestsHelper {
    val personsCache = listOf(
        Person(
            id = 1,
            lastName = "Müller",
            name = "Hans",
            zipCode = "67742",
            city = "Lauterecken",
            color = Color.findColorById(1)
        ),
        Person(
            id = 2,
            lastName = "Petersen",
            name = "Peter",
            zipCode = "18439",
            city = "Stralsund",
            color = Color.findColorById(2)
        ),
        Person(
            id = 3,
            lastName = "Johnson",
            name = "Johnny",
            zipCode = "88888",
            city = "made up",
            color = Color.findColorById(3)
        ),
        Person(
            id = 4,
            lastName = "Millenium",
            name = "Milly",
            zipCode = "77777",
            city = "made up too",
            color = Color.findColorById(4)
        ),
        Person(
            id = 5,
            lastName = "Müller",
            name = "Jonas",
            zipCode = "32323",
            city = "Hansstadt",
            color = Color.findColorById(5)
        ),
        Person(
            id = 6,
            lastName = "Fujitsu",
            name = "Tastatur",
            zipCode = "42342",
            city = "Japan",
            color = Color.findColorById(6)
        ),
        Person(
            id = 7,
            lastName = "Andersson",
            name = "Anders",
            zipCode = "32132",
            city = "Schweden",
            color = Color.findColorById(2)
        ),
        Person(
            id = 8,
            lastName = "Gerber",
            name = "Gerda",
            zipCode = "76535",
            city = "Woanders",
            color = Color.findColorById(3)
        ),
        Person(
            id = 9,
            lastName = "Klaussen",
            name = "Klaus",
            zipCode = "43246",
            city = "Hierach",
            color = Color.findColorById(2)
        ),
        Person(
            id = 10,
            lastName = "Fuchs",
            name = "Uwe",
            zipCode = "22765",
            city = "Hamburg",
            color = null
        ),
    )
}

