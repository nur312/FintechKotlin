package ru.tinkoff.fintech.homework1.pets

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class DogTest {

    /*
    * 1) Написать unit-тесты, покрывающие все пограничные состояния, метода одного из классов из задания 2 лекции 1.
    *
    * Выбрал метод memorizeWord(word: String) из класса Dog.
    * */

    @Test
    fun `проверяем случай, когда собака не знает ни однгог слова`() {

        val dog = Dog("Кеша")
        val expected = ""

        val speech = dog.getSpeech()

        assertEquals(expected, speech)
    }

    @Test
    fun `проверяем запоминаются ли слова собакой`() {

        val dog = Dog("Кеша")
        dog.memorizeWord("доллар")
        dog.memorizeWord("остановись")
        val expected = "Dog Кеша:\nдоллар\nостановись\n"

        val speech = dog.getSpeech()

        assertEquals(expected, speech)
    }

    @Test
    fun `проверяем не запоминает ли собака слишком много слов`() {

        val dog = Dog("Кеша", maxMemorizeWordCount = 2)
        dog.memorizeWord("доллар")
        dog.memorizeWord("остановись")
        dog.memorizeWord("уже")
        val expected = "Dog Кеша:\nдоллар\nостановись\n"

        val speech = dog.getSpeech()

        assertEquals(expected, speech)
    }
}