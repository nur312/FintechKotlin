package ru.tinkoff.fintech.homework2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class StackImplTest {

    private lateinit var stack: Stack<Int>

    @Test
    fun `check if an initial stack is empty`() {
        stack = StackImpl(3)

        val stackSize = stack.size

        assertEquals(0, stackSize)
    }

    @Test
    fun `empty stack is threw a exception if execute a pop() method`() {
        stack = StackImpl(3)

        assertThrows(ArrayIndexOutOfBoundsException::class.java) { stack.pop() }
    }

    @Test
    fun `empty stack is threw a exception if execute a peek() method`() {
        stack = StackImpl(3)

        assertThrows(ArrayIndexOutOfBoundsException::class.java) { stack.peek() }
    }

    @Test
    fun `check if it is possible to create a stack with a negative size`() {

        assertThrows(NegativeArraySizeException::class.java) { stack = StackImpl(-1) }
    }

    @Test
    fun `check if we can add to stack elements`() {
        for (capacity in listOf(4, 5)) {

            stack = StackImpl(capacity)

            for (i in 1..stack.capacity) {
                stack.push(i)

                val stackSize = stack.size
                val lastInElement = stack.peek()

                assertAll(
                    { assertEquals(i, stackSize) },
                    { assertEquals(i, lastInElement) }
                )
            }
        }
    }


    @Test
    fun `check if stack throws an exception when it is added many elements`() {
        for (capacity in listOf(0, 4, 5)) {

            stack = StackImpl(capacity)

            for (i in 1..stack.capacity) {

                stack.push(i)
            }

            assertThrows(ArrayStoreException::class.java) { stack.push(4) }
        }
    }

    @Test
    fun `check if stack deletes an element`() {
        for (capacity in listOf(4, 5)) {

            stack = StackImpl(capacity)

            for (i in 1..stack.capacity) {

                stack.push(i)
            }

            for (i in stack.capacity downTo 1) {

                val stackSize = stack.size
                val poppedElement = stack.pop()

                assertAll(
                    { assertEquals(i, stackSize) },
                    { assertEquals(i, poppedElement) }
                )
            }

            assertEquals(0, stack.size)
        }
    }

}