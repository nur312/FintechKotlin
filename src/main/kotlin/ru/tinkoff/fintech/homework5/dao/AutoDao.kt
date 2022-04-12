package ru.tinkoff.fintech.homework5.dao

import ru.tinkoff.fintech.homework5.entity.Auto

interface AutoDao {
    fun getAutos(): List<Auto>
}