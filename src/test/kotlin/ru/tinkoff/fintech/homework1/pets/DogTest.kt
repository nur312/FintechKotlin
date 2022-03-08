package ru.tinkoff.fintech.homework1.pets

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class DogTest {

    @Test
    fun `проверяем запоминаются ли слова собакой`() {
        val dog = Dog("Кеша")

        dog.memorizeWord("доллар")
        dog.memorizeWord("остановись")

        val expected = listOf("доллар", "остановись")

        assertEquals(expected, dog.getWordsAsList())
    }

    @Test
    fun `проверяем не запоминает ли собака слишком много слов`() {

        val dog = Dog("Кеша", maxMemorizeWordCount = 2)

        dog.memorizeWord("доллар")
        dog.memorizeWord("остановись")
        dog.memorizeWord("уже")

        val expected = listOf("доллар", "остановись")

        assertEquals(expected, dog.getWordsAsList())
    }
}