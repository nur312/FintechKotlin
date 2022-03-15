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
    println(pet.makeSound())

    pet = dog

    // dog's sound
    println(pet.makeSound())

    // mur, mur...
    println(cat.vibrate(1))

    // russian dod :)
    println(dog.makeSound("гав"))

    dog.memorizeWord("Hello")
    dog.memorizeWord("world")
    dog.memorizeWord("Impossible")

    println(dog.getSpeech())


    val ensemble = Ensemble(cat, dog)



    println(ensemble.makeMusic())


}