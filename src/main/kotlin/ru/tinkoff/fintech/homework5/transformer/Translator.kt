package ru.tinkoff.fintech.homework5.transformer

interface Translator {
    fun translate(word: String, from: String = "RUS", to: String = "ENG"): String
}