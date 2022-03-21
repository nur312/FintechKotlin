package ru.tinkoff.fintech.homework5.transformer

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import ru.tinkoff.fintech.homework5.entity.Auto

class TransformerImplTest {

    private val transformer: Transformer = TransformerImpl()

    @Test
    fun `try to convert one of cars`() {
        val auto = Auto(mark = "Тойота", model = "Камри", typeOfBody = "Седан", gasMileage = 7.7, price = 2_499_999.99)

        val translation = transformer.transform(auto)

        val expectedPrice = 2_499_999.99 * 0.0096

        assertAll(
            { assertEquals("Toyota", translation.mark) },
            { assertEquals("Camry", translation.model) },
            { assertEquals("Sedan", translation.typeOfBody) },
            { assertEquals(7.7, translation.gasMileage) },
            { assertEquals(expectedPrice, translation.price) },
        )

    }
}