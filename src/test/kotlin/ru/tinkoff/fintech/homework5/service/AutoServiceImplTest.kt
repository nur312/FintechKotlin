package ru.tinkoff.fintech.homework5.service

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import ru.tinkoff.fintech.homework5.dao.AutoDaoImpl
import ru.tinkoff.fintech.homework5.entity.Auto

internal class AutoServiceImplTest {

    private val autos = AutoDaoImpl().getAutos()
    private val autoService: AutoService = AutoServiceImpl()

    @Test
    fun translateToEnglish() {
        val rate = 0.0096

        val expected = listOf(
            Auto(mark = "Toyota", model = "Camry", typeOfBody = "Sedan", gasMileage = 7.7, price = 2_499_999.99 * rate),
            Auto(
                mark = "Toyota",
                model = "Land Cruiser",
                typeOfBody = "SUV",
                gasMileage = 14.4,
                price = 3999999.99 * rate
            ),
            Auto(
                mark = "Toyota",
                model = "Prius",
                typeOfBody = "Hatchback",
                gasMileage = 4.7,
                price = 1_499_999.99 * rate
            ),
            Auto(mark = "Lexus", model = "GS300", typeOfBody = "Sedan", gasMileage = 8.7, price = 4_499_999.99 * rate),
            Auto(
                mark = "Lexus",
                model = "GX570",
                typeOfBody = "SUV",
                gasMileage = 17.7,
                price = 4_499_999.99 * rate
            )
        ).sortedBy(Auto::price)

        val transformation = autoService.translate(autos)

        assertEquals(expected, transformation)
    }

    @Test
    fun groupCarsByTypeOfBody() {
        val expected = mapOf(
            "Седан" to listOf(
                Auto(mark = "Тойота", model = "Камри", typeOfBody = "Седан", gasMileage = 7.7, price = 2_499_999.99),
                Auto(mark = "Лексус", model = "ДжиЭс300", typeOfBody = "Седан", gasMileage = 8.7, price = 4_499_999.99),
            ),
            "Внедорожник" to listOf(
                Auto(
                    mark = "Тойота",
                    model = "Ленд Крузер",
                    typeOfBody = "Внедорожник",
                    gasMileage = 14.4,
                    price = 3999999.99
                ),
                Auto(
                    mark = "Лексус",
                    model = "ДжиИкс570",
                    typeOfBody = "Внедорожник",
                    gasMileage = 17.7,
                    price = 4_499_999.99
                ),
            ),
            "Хэтчбек" to listOf(
                Auto(mark = "Тойота", model = "Приус", typeOfBody = "Хэтчбек", gasMileage = 4.7, price = 1_499_999.99),
            )
        )

        val grouped = autoService.groupCarsByTypeOfBody(autos)

        assertEquals(expected, grouped)
    }

    @Test
    fun filterCarsAndTakeFirstKElements() {
        val expected = listOf("Тойота Камри", "Тойота Ленд Крузер", "Тойота Приус").sorted()

        val filtered = autoService.filterCarsAndTake(autos) { it.mark == "Тойота" }.sorted()

        assertEquals(expected, filtered)
    }
}