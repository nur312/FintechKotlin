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
        val model = translator.translate(auto.model, langFrom, langTo)
        val typeOfBody = translator.translate(auto.typeOfBody, langFrom, langTo)
        val gasMileage = auto.gasMileage
        val price = converter.convertMoney(auto.price, currencyFrom, currencyTo)

        return Auto(name, model, typeOfBody, gasMileage, price)
    }
}