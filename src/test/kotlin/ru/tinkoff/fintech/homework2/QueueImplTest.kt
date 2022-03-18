@file:Suppress("NonAsciiCharacters")

package ru.tinkoff.fintech.homework2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class QueueImplTest {

    private lateinit var queue: Queue<Int>

    @Test
    fun `check if an initial queue is empty`() {
        queue = QueueImpl(3)

        val stackSize = queue.size

        assertEquals(0, stackSize)
    }

    @Test
    fun `empty queue is threw a exception if execute a remove() method`() {
        queue = QueueImpl(3)

        assertThrows(NoSuchElementException::class.java) { queue.remove() }
    }

    @Test
    fun `empty queue is threw a exception if execute a element() method`() {
        queue = QueueImpl(3)

        assertThrows(NoSuchElementException::class.java) { queue.element() }
    }

    @Test
    fun `check if it is possible to create a queue with a negative size`() {

        assertThrows(NegativeArraySizeException::class.java) { queue = QueueImpl(-1) }
    }

    @Test
    fun `метод offer() - добавляются ли элементы в очередь`() {
        for (capacity in listOf(4, 5)) {

            queue = QueueImpl(capacity)

            for (i in 1..capacity) {
                val res = queue.offer(i)

                assertAll(
                    { assertTrue(res) },
                    { assertEquals(i, queue.size) }
                )

            }
        }
    }

    @Test
    fun `метод offer() - при попытке добавить слишком много элементов метод offer у Queue должно вернуть false`() {
        for (capacity in listOf(4, 5)) {

            queue = QueueImpl(capacity)

            for (i in 1..capacity) {

                queue.offer(i)
            }

            val res = queue.offer(0)

            assertFalse(res)
        }
    }

    @Test
    fun `poll() - проверяем соблюдают ли элементы очередь`() {
        for (capacity in listOf(4, 5)) {

            queue = QueueImpl(capacity)

            for (i in 1..capacity) {

                queue.offer(i)
            }

            for (i in 1..capacity) {
                val polledElement = queue.poll()

                assertAll(
                    { assertEquals(i, polledElement) },
                    { assertEquals(capacity - i, queue.size) }
                )
            }
        }
    }

    @Test
    fun `Переходит ли элемент в начало массива`() {
        queue = QueueImpl(3)
        queue.offer(1)
        queue.offer(2)
        queue.offer(3)
        queue.poll()
        queue.poll()

        assertTrue(queue.offer(4))
        assertTrue(queue.offer(4))

        val firstPolledElement = queue.poll()
        val secondPolledElement = queue.poll()
        val thirdPolledElement = queue.poll()

        assertAll(
            { assertEquals(3, firstPolledElement) },
            { assertEquals(4, secondPolledElement) },
            { assertEquals(4, thirdPolledElement) },
        )
    }

    @Test
    fun `правильно ли работает очередь при удалении всех элементов`() {
        queue = QueueImpl(1)
        queue.offer(1)
        queue.poll()

        val res = queue.offer(3)
        val polledElement = queue.poll()

        assertAll(
            { assertTrue(res) },
            { assertEquals(1, queue.size) },
            { assertEquals(3, polledElement) }
        )
    }

    @Test
    fun `проверяем метод peek()`() {
        queue = QueueImpl(2)
        queue.offer(1)
        queue.offer(2)

        val firstPeek = queue.peek()
        val secondPeek = queue.peek()

        assertEquals(1, firstPeek)
        assertEquals(1, secondPeek)
    }

    @Test
    fun `метод peek() должен вернуть null, если очередь пуста`() {
        queue = QueueImpl(2)
        queue.offer(1)
        queue.offer(2)
        queue.poll()
        queue.poll()

        val peekedElement = queue.peek()

        assertNull(peekedElement)
    }

    @Test
    fun `мы проверили тчательно метод peek(), у метода element() проверим только исключение`() {
        queue = QueueImpl(2)
        queue.offer(1)
        queue.offer(2)
        queue.poll()
        queue.poll()

        assertThrows(NoSuchElementException::class.java) { queue.element() }
    }

    @Test
    fun `проверяем выбрасывает ли исключение метод remove(), а остальное не нужно, тк тчательно проверили poll()`() {
        queue = QueueImpl(2)

        assertThrows(NoSuchElementException::class.java) { queue.remove() }
    }
}