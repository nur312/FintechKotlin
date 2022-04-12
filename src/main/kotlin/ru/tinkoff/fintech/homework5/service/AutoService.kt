package ru.tinkoff.fintech.homework5.service

import ru.tinkoff.fintech.homework5.entity.Auto

interface AutoService {

    /**
     * Метод, который преобразует поля нашего класса в описание на английском,
     * а цену преобразует в валюту (курс, можно создать константой) и возвращает
     * новую коллекцию отсортированную по возрастанию цены.
     */
    fun translate(
        autos: List<Auto>, langFrom: String = "RUS",
        langTo: String = "ENG",
        currencyFrom: String = "RUB",
        currencyTo: String = "USD"
    ): List<Auto>

    /**
     * Метод, группирующий элементы списка по типу кузова или по какому-либо заранее выбранному полю
     */
    fun groupCarsByTypeOfBody(autos: List<Auto>): Map<String, List<Auto>>

    /**
     * Метод, возвращающий количество элементов из списка соответствующих переданному условию,
     * после чего преобразовать список названий и взять первые 3 элемента
     */
    fun filterCarsAndTake(autos: List<Auto>, k: Int = 3, predicate: (Auto) -> Boolean): List<String>
}