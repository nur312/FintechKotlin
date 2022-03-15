package ru.tinkoff.fintech.homework1.ensemble

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import ru.tinkoff.fintech.homework1.pets.Cat
import ru.tinkoff.fintech.homework1.pets.Dog


class EnsembleTest {

    @Test
    fun `проверяем исполнение`() {

        /*2) С помощью тест-дублеров(Mock или Spy) настроить заглушку для тестирования.
        Выбрал Mock, так как в Ensemble вызываются только два метода из класса Dog.
        Заглушка должна быть настроена как минимум для 2-х наборов входных данных.
        Настоил для методов getSpeech() и makeSound() класаа Dog*/

        val dog = mockk<Dog>()
        every { dog.getSpeech() } returns "Dog Джо:\nАнсамбль\nНачинай\n"
        every { dog.makeSound() } returns "Dog Джо: \n\tгыгы\n"
        val ensemble = Ensemble(Cat("Кетрин"), dog)
        val expected = "Dog Джо:\n" +
                "Ансамбль\n" +
                "Начинай\n" +
                "Ensemble's musicCat Кетрин:\n" +
                "\tmur\n" +
                "\tmur\n" +
                "Dog Джо: \n" +
                "\tгыгы\n" +
                "Cat Кетрин:\n" +
                "\tmeow\n"
        /*3) Настроенную заглушку передавать в конструктор класса из задания 4 лекции 1. Написать unit-тесты,
        проверяющие функционал класса, принимающего заглушку в качестве параметра в конструкторе.*/

        val music = ensemble.makeMusic()

        assertEquals(expected, music)
        /*4) С помощью ф-ии verify протестировать кол-во вызовов заглушки.*/
        verify(exactly = 1) { dog.getSpeech() }
        verify(exactly = 1) { dog.makeSound() }
    }

    @Test
    fun `проверяем правильно ли составляются списки участников`() {

        val ensemble = Ensemble(Cat("Кетрин"), Dog("Дореан"))
        val expected = listOf("Кетрин", "Дореан")

        val listOfParticipants = ensemble.getListOfParticipants()

        assertEquals(expected, listOfParticipants)
    }
}