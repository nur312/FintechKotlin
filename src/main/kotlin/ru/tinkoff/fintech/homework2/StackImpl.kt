package ru.tinkoff.fintech.homework2

@Suppress("UNCHECKED_CAST")
class StackImpl<T>(override val capacity: Int) : Stack<T> {

    override var size: Int = 0
        private set

    private var array = arrayOfNulls<Any>(capacity)


    override fun push(element: T) {
        if (size == array.size) {

            throw ArrayStoreException("Стэк переполнен")
        }

        array[size] = element
        ++size
    }

    override fun pop(): T {
        size--

        if (size < 0) {

            size++
            throw ArrayIndexOutOfBoundsException("Нельзя удалять из пустого тэка элемент")
        }

        val element = array[size] as T
        array[size] = null

        return element
    }

    override fun peek(): T {
        if (size == 0) {

            throw ArrayIndexOutOfBoundsException("Нельзся получить элемент из пустого стэка")
        }

        return array[size - 1] as T
    }
}