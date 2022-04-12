package ru.tinkoff.fintech.homework5.dao

import ru.tinkoff.fintech.homework5.entity.*

class AutoDaoImpl : AutoDao {

    private val autos = listOf(
        Auto(mark = "Тойота", model = "Камри", typeOfBody = "Седан", gasMileage = 7.7, price = 2_499_999.99),
        Auto(mark = "Тойота", model = "Ленд Крузер", typeOfBody = "Внедорожник", gasMileage = 14.4, price = 3999999.99),
        Auto(mark = "Тойота", model = "Приус", typeOfBody = "Хэтчбек", gasMileage = 4.7, price = 1_499_999.99),
        Auto(mark = "Лексус", model = "ДжиЭс300", typeOfBody = "Седан", gasMileage = 8.7, price = 4_499_999.99),
        Auto(mark = "Лексус", model = "ДжиИкс570", typeOfBody = "Внедорожник", gasMileage = 17.7, price = 4_499_999.99),
    )

    override fun getAutos() = autos
}