package ru.tinkoff.fintech.homework5.transformer

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class ConverterImplTest {

    private val converter: Converter = ConverterImpl()

    @Test
    fun `convert rubles to dollars`() {
        val expected = 10_000.0 * 0.0096
        val convertedValue = converter.convertMoney(10_000.0)

        assertEquals(expected, convertedValue)
    }

    @Test
    fun `convert a unknown currency to dollars`() {

        assertThrows(IllegalArgumentException::class.java) { converter.convertMoney(10_000.0, from = "UNKNOWN") }
    }
}