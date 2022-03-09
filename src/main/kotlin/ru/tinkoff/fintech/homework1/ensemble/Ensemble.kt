package ru.tinkoff.fintech.homework1.ensemble

import ru.tinkoff.fintech.homework1.pets.Cat
import ru.tinkoff.fintech.homework1.pets.Dog

class Ensemble(private val cat: Cat, private val dog: Dog) {

    fun getListOfParticipants() = listOf(cat.name, dog.name)

    fun makeMusic(): String {

        val builder = StringBuilder()

        builder.append(dog.getSpeech())

        builder.append("Ensemble's music")

        builder.append(cat.vibrate(2))

        builder.append(dog.makeSound())

        builder.append(cat.makeSound())

        return builder.toString()
    }
}