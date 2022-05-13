package ru.tinkoff.fintech.homework8

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.TestInstance

@Suppress("NonAsciiCharacters")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ThreadPoolTest {

    private lateinit var threadPool: ThreadPool

    @BeforeEach
    fun setUp() {
        threadPool = ThreadPool(3)
    }

    @AfterEach
    fun tearDown() {
        try {
            threadPool.shutdown()
        } catch (_: Exception) {
        }
    }

    @Synchronized
    @Test
    fun `Демонстрация работы ThreadPool`() {
        println("*********************************")

        for (i in 1..5) {
            threadPool.execute {
                println("begin of task #$i in the thread #${Thread.currentThread().name}")
                Thread.sleep(1000)
                println("end of task #$i  in the thread #${Thread.currentThread().name}")
            }
        }
        for (i in 1..5) {
            Thread.sleep(1000)
            if (i == 1) {
                println("1 second")
            } else {
                println("$i seconds")
            }
        }

        threadPool.shutdown()

        println("demonstration: end of the method")
        println("*********************************")
    }

    @Synchronized
    @Test
    fun `проверка метода execute`() {
        val isDoneArray = Array(5) { false }
        for (i in isDoneArray.indices) {
            threadPool.execute {
                Thread.sleep(1000)
                isDoneArray[i] = true
            }
        }
        Thread.sleep(5000)

        assertTrue(isDoneArray.all { it })
    }

    @Synchronized
    @Test
    fun `Проверка метода shutdown - когда потоки не выполняют задания`() {
        for (i in 1..5) {
            threadPool.execute {
                Thread.sleep(1000)
            }
        }

        Thread.sleep(5000)

        val isRunningTasksFinished = threadPool.shutdown()

        assertTrue(isRunningTasksFinished)
    }

    @Synchronized
    @Test
    fun `Проверка метода shutdown - когда потоки еще выполняют задания`() {
        for (i in 1..9) {
            threadPool.execute {
                Thread.sleep(1000)
            }
        }

        Thread.sleep(300)

        val isRunningTasksFinished = threadPool.shutdown()

        assertFalse(isRunningTasksFinished)
    }
}