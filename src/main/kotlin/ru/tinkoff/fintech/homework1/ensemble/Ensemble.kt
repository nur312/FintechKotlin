package ru.tinkoff.fintech.homework1.ensemble

import ru.tinkoff.fintech.homework1.pets.*

class Ensemble(private val cat: Cat, private val dog: Dog) {

    fun makeMusic() {

        println("Ensemble's music")

        cat.vibrate(4)

        dog.makeSound("wow")

        dog.times = 3


        cat.makeSound()
    }
}