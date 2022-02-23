package ru.tinkoff.fintech.homework1.pets

class Dog(override val name: String, override val sound: String = "bark", private val maxMemorizeWordCount: Int = 3) :
    Pet {


    private val words: MutableList<String> = ArrayList(maxMemorizeWordCount)


    override fun makeSound() {

        println("Dog $name: \n\t$sound")

    }

    fun makeSound(anotherSound: String) {

        println("Dog $name: \n\t$anotherSound")
    }

    fun memorizeWord(word: String) {

        if (maxMemorizeWordCount == words.size) {
            println(
                "Dog $name: \n\tcannot memorize the new word"
            )

            return
        }

        words.add(word)
    }

    fun speak() {

        println("Dog $name:")

        words.forEach { println(it) }
    }


}