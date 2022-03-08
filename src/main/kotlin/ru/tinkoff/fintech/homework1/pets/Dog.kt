package ru.tinkoff.fintech.homework1.pets

class Dog(override val name: String, override val sound: String = "bark", private val maxMemorizeWordCount: Int = 3) :
    Pet {


    private val words: MutableList<String> = ArrayList(maxMemorizeWordCount)


    override fun makeSound() {

        println(getSoundAsText())
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

        println(getSpeech())
    }


    fun getSpeech() : String {

        val builder = StringBuilder("Dog $name:\n")

        getWordsAsList().forEach { builder.append(it).append("\n") }

        return builder.toString()
    }

    fun getWordsAsList(): List<String> = words

    fun getSoundAsText() = "Dog $name: \n\t$sound"

}