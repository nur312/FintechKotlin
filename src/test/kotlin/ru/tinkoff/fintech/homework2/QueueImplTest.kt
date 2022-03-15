@file:Suppress("NonAsciiCharacters")

package ru.tinkoff.fintech.homework2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class QueueImplTest {

    private lateinit var queue: Queue<Int>

    @Test
    fun `метод offer() - добавляются ли элементы в очередь`() {
        for (capacity in 1..9) {

            queue = QueueImpl(capacity)

            for (i in 1..capacity) {


                assertTrue(queue.offer(i))
                assertEquals(i, queue.size)
            }
        }
    }

    @Test
    fun `метод offer() - при попытке добавить слишком много элементов метод offer у Queue должно вернуть false`() {
        for (capacity in 1..9) {

            queue = QueueImpl(capacity)

            for (i in 1..capacity) {

                queue.offer(i)
            }

            assertFalse(queue.offer(0))
        }
    }

    @Test
    fun `poll() - проверям соблюдают ли элементы очередь`() {
        for (capacity in 1..9) {

            queue = QueueImpl(capacity)

            for (i in 1..capacity) {

                queue.offer(i)
            }

            for (i in 1..capacity) {

                assertEquals(i, queue.poll())
                assertEquals(capacity - i, queue.size)
            }
        }
    }

    @Test
    fun `ереходит ли элемент в начало массива`() {
        queue = QueueImpl(3)
        queue.offer(1)
        queue.offer(2)
        queue.offer(3)
        queue.poll()
        queue.poll()

        assertTrue(queue.offer(4))
        assertTrue(queue.offer(4))

        assertAll(
            { assertEquals(3, queue.poll()) },
            { assertEquals(4, queue.poll()) },
            { assertEquals(4, queue.poll()) },
        )
    }

    @Test
    fun `правильно ли работает очередь при удалении всех элементов`() {
        queue = QueueImpl(1)
        queue.offer(1)
        queue.poll()

        assertTrue(queue.offer(3))

        assertAll(
            { assertEquals(1, queue.size) },
            { assertEquals(3, queue.poll()) }
        )
    }

    @Test
    fun `проверяем метод peek()`() {
        queue = QueueImpl(2)
        queue.offer(1)
        queue.offer(2)

        assertEquals(1, queue.peek())
        assertEquals(1, queue.peek())
    }

    @Test
    fun `метод peek() должен вернуть null, если очередь пуста`() {
        queue = QueueImpl(2)
        queue.offer(1)
        queue.offer(2)
        queue.poll()
        queue.poll()

        assertNull(queue.peek())
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