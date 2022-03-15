package ru.tinkoff.fintech.homework2

interface Queue<T> : Collection {

    /**
     * возвращает элемент из головы очереди. Элемент не удаляется.
     * Если очередь пуста, инициируется исключение NoSuchElementException.
     */
    fun element(): T

    /**
     * Удаляет элемент из головы очереди, возвращая его.
     * Инициирует исключение NoSuchElementException, если очередь пуста.
     */
    fun remove(): T

    /**
     * Возвращает элемент из головы очереди. Возвращает null, если очередь пуста.
     * Элемент не удаляется.
     */
    fun peek(): T?

    /**
     * Возвращает элемент из головы очереди и удаляет его.
     * Возвращает null, если очередь пуста.
     */
    fun poll(): T?

    /**
     * Пытается добавить оbj в очередь. Возвращает true,
     * если оbj добавлен, и false в противном случае.
     */
    fun offer(element: T) : Boolean

}