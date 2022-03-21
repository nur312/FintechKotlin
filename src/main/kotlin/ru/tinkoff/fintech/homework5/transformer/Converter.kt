package ru.tinkoff.fintech.homework5.transformer

interface Converter {
    fun convertMoney(amount: Double, from: String = "RUB", to: String = "USD"): Double?
}