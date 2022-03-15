package ru.tinkoff.fintech.homework2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


internal class StackImplTest {

    private lateinit var stack: Stack<Int>

    @Test
    fun `check if an initial stack is empty`() {
        stack = StackImpl(3)

        assertEquals(0, stack.size)
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
    fun `check if we can add to stack elements`() {
        for (capacity in 1..9) {

            stack = StackImpl(capacity)

            for (i in 1..stack.capacity) {
                stack.push(i)
                assertEquals(i, stack.size)
                assertEquals(i, stack.peek())
            }
        }
    }


    @Test
    fun `check if stack throws an exception when it is added many elements`() {
        for (capacity in 1..9) {

            stack = StackImpl(capacity)

            for (i in 1..stack.capacity) {

                stack.push(i)
            }

            assertThrows(ArrayStoreException::class.java) { stack.push(4) }
        }
    }

    @Test
    fun `check if stack deletes an element`() {
        for (capacity in 1..9) {

            stack = StackImpl(capacity)

            for (i in 1..stack.capacity) {

                stack.push(i)
            }

            for (i in stack.capacity downTo 1) {

                assertEquals(i, stack.size)
                assertEquals(i, stack.pop())
            }

            assertEquals(0, stack.size)
        }
    }

}