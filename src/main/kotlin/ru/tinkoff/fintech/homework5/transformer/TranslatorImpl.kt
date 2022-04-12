package ru.tinkoff.fintech.homework5.transformer

class TranslatorImpl : Translator {

    private val dictionary = mapOf(
        "RUS" to mapOf(
            "ENG" to mapOf(
                "Тойота" to "Toyota",
                "Приус" to "Prius",
                "Камри" to "Camry",
                "Ленд Крузер" to "Land Cruiser",
                "Лексус" to "Lexus",
                "ДжиЭс300" to "GS300",
                "ДжиИкс570" to "GX570",
                "Внедорожник" to "SUV",
                "Седан" to "Sedan",
                "Хэтчбек" to "Hatchback",
            )
        ),
        "ENG" to mapOf(
            "RUS" to mapOf(
                "Toyota" to "Тойота",
                "Prius" to "Приус",
                "Camry" to "Камри",
                "Land Cruiser" to "Ленд Крузер",
                "Lexus" to "Лексус",
                "GS300" to "ДжиЭс300",
                "GX570" to "ДжиИкс570",
                "SUV" to "Внедорожник",
                "Sedan" to "Седан",
                "Hatchback" to "Хэтчбек",
            )
        ),
    )

    override fun translate(word: String, from: String, to: String): String {

        val fromToDictionary = dictionary[from]?.get(to)
            ?: throw IllegalArgumentException("There is not dictionary from $from to $to")

        return fromToDictionary[word]
            ?: throw NoSuchElementException("There is not the word = \"$word\"")
    }
}