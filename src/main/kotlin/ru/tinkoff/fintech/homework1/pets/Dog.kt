package ru.tinkoff.fintech.homework1.pets

class Dog(override val name: String, override val sound: String = "bark", private val maxMemorizeWordCount: Int = 3) :
    Pet {


    private val words: MutableList<String> = ArrayList(maxMemorizeWordCount)


    override fun makeSound() = "Dog $name: \n\t$sound\n"

    fun makeSound(anotherSound: String) = "Dog $name: \n\t$anotherSound\n"

    fun memorizeWord(word: String) {

        if (maxMemorizeWordCount == words.size) {
            println(
                "Dog $name: \n\tcannot memorize the new word"
            )

            return
        }

        words.add(word)
    }


    fun getSpeech(): String {

        if (words.isEmpty()) {

            return ""
        }

        val builder = StringBuilder("Dog $name:\n")

        words.forEach { builder.append(it).append("\n") }

        return builder.toString()
    }

}