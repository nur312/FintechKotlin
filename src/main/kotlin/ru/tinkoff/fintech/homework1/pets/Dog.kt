package ru.tinkoff.fintech.homework1.pets

class Dog(override val name: String, override val sound: String = "bark", private val times: Int = 1) : Pet {


    override fun makeSound() {

        println("Dog $name: ")

        for (i in 1..times) {
            println("\t$sound")
        }
    }

    fun makeSound(anotherSound: String) {

        println("Dog $name: ")

        for (i in 1..times) {
            println("\t$anotherSound")
        }
    }


}