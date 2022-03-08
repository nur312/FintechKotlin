package ru.tinkoff.fintech.homework1.ensemble

import io.mockk.every
import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import ru.tinkoff.fintech.homework1.pets.Cat
import ru.tinkoff.fintech.homework1.pets.Dog


internal class EnsembleTest {


    @Test
    fun `тестируем правильно ли произносит речь собака`() {

        val dog = spyk(Dog("Джо"))

        every { dog.getWordsAsList() } returns listOf("Ансамбль", "Начинай")

        assertEquals("Dog Джо:\nАнсамбль\nНачинай\n", dog.getSpeech())

        verify(exactly = 1) { dog.getWordsAsList() }
    }

    @Test
    fun `тестируем правильно ли произносит звук собака`() {

        val dog = spyk(Dog("Джо"))

        every { dog.sound } returns "ррр"

        assertEquals("Dog Джо: \n\tррр", dog.getSoundAsText())

        verify(exactly = 1) { dog.sound }
    }

    @Test
    fun `проверяем исполнение`() {

        val dog = spyk(Dog("Джо"))

        every { dog.getWordsAsList() } returns listOf("Ансамбль", "Начинай")

        every { dog.sound } returns "ррр"

        val ensemble = Ensemble(Cat("Кетрин"), dog)

        ensemble.makeMusic()

        verify(exactly = 1) { dog.getWordsAsList() }
        verify(exactly = 1) { dog.sound }
    }

    @Test
    fun `проверяем правильно ли составляются списки участников`() {
        val ensemble = Ensemble(Cat("Кетрин"), Dog("Дореан"))

        assertEquals(ensemble.getListOfParticipants(), listOf("Кетрин", "Дореан"))
    }
}