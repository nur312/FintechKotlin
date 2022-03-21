package ru.tinkoff.fintech.homework5.transformer

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TranslatorImplTest {

    private val translator: Translator = TranslatorImpl()

    @Test
    fun `there is checked just a word because map doesn't require a testing`() {
        val translation = translator.translate("Лексус")
        val expected = "Lexus"

        assertEquals(expected, translation)
    }

    @Test
    fun `null is expected if there is not a translation`() {
        val translation = translator.translate("Бексус")

        assertNull(translation)
    }
}