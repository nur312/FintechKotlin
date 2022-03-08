package ru.tinkoff.fintech.homework1.ensemble

import ru.tinkoff.fintech.homework1.pets.Cat
import ru.tinkoff.fintech.homework1.pets.Dog

class Ensemble(private val cat: Cat, private val dog: Dog) {

    fun getListOfParticipants() = listOf(cat.name, dog.name)

    fun makeMusic() {

        dog.speak()

        println("Ensemble's music")

        cat.vibrate(4)

        dog.makeSound()


        cat.makeSound()
    }
}