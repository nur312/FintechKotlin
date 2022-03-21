package ru.tinkoff.fintech.homework5.transformer

import ru.tinkoff.fintech.homework5.entity.Auto

interface Transformer {
    fun transform(
        auto: Auto,
        langFrom: String = "RUS",
        langTo: String = "ENG",
        currencyFrom: String = "RUB",
        currencyTo: String = "USD"
    ): Auto
}