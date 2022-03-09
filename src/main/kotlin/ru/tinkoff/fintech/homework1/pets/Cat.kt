package ru.tinkoff.fintech.homework1.pets

class Cat(override val name: String, override val sound: String = "meow") : Pet {


    override fun makeSound() = "Cat $name:\n\t$sound\n"

    fun vibrate(times: Int = 1): String {

        val builder = StringBuilder("Cat $name:\n")

        for (i in 1..times) {
            builder.append("\t${vibration}\n")
        }

        return builder.toString()
    }

    companion object {
        private const val vibration = "mur"
    }
}