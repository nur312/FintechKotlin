package ru.tinkoff.fintech.homework2

@Suppress("UNCHECKED_CAST")
class QueueImpl<T>(override val capacity: Int) : Queue<T> {

    private val array = arrayOfNulls<Any>(capacity)

    private var leftP = -1
    private var rightP = -1

    override var size: Int = 0
        private set

    override fun offer(element: T): Boolean {
        if (size == capacity) {
            return false
        }
        if (leftP == -1) {
            leftP = 0
        }

        rightP = (rightP + 1) % capacity
        array[rightP] = element

        ++size
        return true
    }


    override fun element(): T {

        return peek() ?: throw NoSuchElementException("Очередь пуста")
    }

    override fun peek(): T? {
        if (size == 0) {
            return null
        }

        return array[leftP] as T
    }

    override fun remove(): T {

        return poll() ?: throw NoSuchElementException("Очередь пуста")
    }

    override fun poll(): T? {
        if (size == 0) {
            return null
        }

        val element = array[leftP] as T
        array[leftP] = null

        leftP = (leftP + 1) % capacity

        if (size == 1) {

            leftP = -1
            rightP = -1
        }

        size--
        return element
    }


}