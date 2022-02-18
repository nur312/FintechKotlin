package ru.tinkoff.fintech.homework1.ensemble

import ru.tinkoff.fintech.homework1.pets.*

class Ensemble(val cat: Cat, val dog: Dog) {

    fun makeMusic() {

        println("Ensemble's music")

        cat.vibrate(4)

        dog.makeSound("wow")

        cat.makeSound()
    }
}