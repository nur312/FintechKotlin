package ru.tinkoff.fintech.homework1.pets

class Cat(override val name: String, override val sound: String = "meow") : Pet {


    private val vibration = "mur"

    override fun makeSound() {
        println("Cat $name:\n\t$sound")
    }

    fun vibrate(times: Int = 3) {
        println("Cat $name:")
        for (i in 1..times) {
            println("\t$vibration")
        }
    }
}