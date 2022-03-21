package ru.tinkoff.fintech.homework5.transformer

import ru.tinkoff.fintech.homework5.entity.Auto

class TransformerImpl : Transformer {

    private val translator: Translator = TranslatorImpl()
    private val converter: Converter = ConverterImpl()

    override fun transform(
        auto: Auto,
        langFrom: String,
        langTo: String,
        currencyFrom: String,
        currencyTo: String
    ): Auto {
        val name = translator.translate(auto.mark, langFrom, langTo)
            ?: error("cannot translate ${auto.mark} to $langTo")
        val model = translator.translate(auto.model, langFrom, langTo)
            ?: error("cannot translate ${auto.model} to $langTo")
        val typeOfBody = translator.translate(auto.typeOfBody, langFrom, langTo)
            ?: error("cannot translate ${auto.typeOfBody} to $langTo")
        val gasMileage = auto.gasMileage
        val price = converter.convertMoney(auto.price, currencyFrom, currencyTo)
            ?: error("cannot translate $currencyFrom to $currencyTo")

        return Auto(name, model, typeOfBody, gasMileage, price)
    }
}