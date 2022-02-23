package ru.tinkoff.fintech.homework1

import ru.tinkoff.fintech.homework1.ensemble.Ensemble
import ru.tinkoff.fintech.homework1.pets.Cat
import ru.tinkoff.fintech.homework1.pets.Dog
import ru.tinkoff.fintech.homework1.pets.Pet

fun main() {

    val cat = Cat("Kiss")
    val dog = Dog(name = "Tor", maxMemorizeWordCount = 2)

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

    dog.memorizeWord("Hello")
    dog.memorizeWord("world")
    dog.memorizeWord("Impossible")

    dog.speak()


    val ensemble = Ensemble(cat, dog)



    ensemble.makeMusic()


}