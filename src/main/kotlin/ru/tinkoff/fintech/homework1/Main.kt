package ru.tinkoff.fintech.homework1

import ru.tinkoff.fintech.homework1.ensemble.Ensemble
import ru.tinkoff.fintech.homework1.pets.*

fun main() {

    val cat = Cat("Kiss")
    val dog = Dog("Tor")

    var pet: Pet = cat

    // cat's sound
    pet.makeSound()

    pet = dog

    // dog's sound
    pet.makeSound()

    // mur, mur...
    cat.vibrate(1)

    // russian dod :)
    dog.makeSound("гав")


    val ensemble = Ensemble(cat, dog)



    ensemble.makeMusic()


}