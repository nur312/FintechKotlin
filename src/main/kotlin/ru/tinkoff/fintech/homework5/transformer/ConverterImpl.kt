package ru.tinkoff.fintech.homework5.transformer

class ConverterImpl : Converter {

    private val currencies = mapOf(
        "RUB" to mapOf("USD" to 0.0096),
        "USD" to mapOf("RUB" to 104.16)
    )

    override fun convertMoney(amount: Double, from: String, to: String): Double {

        val rate = currencies[from]?.get(to) ?: throw IllegalArgumentException("$from - $to is not convertable")

        return amount * rate
    }
}