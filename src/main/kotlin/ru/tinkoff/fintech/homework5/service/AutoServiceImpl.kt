package ru.tinkoff.fintech.homework5.service

import ru.tinkoff.fintech.homework5.entity.Auto
import ru.tinkoff.fintech.homework5.transformer.Transformer
import ru.tinkoff.fintech.homework5.transformer.TransformerImpl

class AutoServiceImpl : AutoService {

    private val transformer: Transformer = TransformerImpl()

    override fun translate(
        autos: List<Auto>, langFrom: String,
        langTo: String,
        currencyFrom: String,
        currencyTo: String
    ): List<Auto> {

        return autos.asSequence().map { transformer.transform(it, langFrom, langTo, currencyFrom, currencyTo) }
            .sortedBy { it.price }.toList()
    }

    override fun groupCarsByTypeOfBody(autos: List<Auto>): Map<String, List<Auto>> {

        return autos.asSequence().groupBy(Auto::typeOfBody)
    }

    override fun filterCarsAndTake(
        autos: List<Auto>,
        k: Int,
        predicate: (Auto) -> Boolean
    ): List<String> {

        return autos.asSequence().filter(predicate).take(k).map { "${it.mark} ${it.model}" }.toList()
    }

}