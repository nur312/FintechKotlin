package ru.tinkoff.fintech.homework8

import java.util.concurrent.BlockingQueue
import java.util.concurrent.Executor
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.locks.ReentrantLock

/**
 * Это класс позволяет выполнять множество задач используя ресурсы множества потоков, которые переиспользуются.
 * Thread Pool состоит из очереди задач и нескольких потоков, которые достают задачи из очереди и выполняют одновременно.
 * @param numOfThreads Количество потоков, которые работают в пуле.
 * @param maxNumOfTask Так как capacity просто ограничивающее число (не создается массив размеров capacity как в
 * ArrayBlockingQueue), нужно установить это значение в два раза большим количеству добавляемых элементов
 * в LinkedBlockingQueue. Создал этот параметр, так как если не задавать capacity в LinkedBlockingQueue,
 * то по умолчанию в нем установится Integer.MAX_VALUE. Это будет опасно тем, что память будет сильно нагружена.
 * По умолчанию выставил значение 10000, чтобы при добавлении новых элементов в LinkedBlockingQueue,
 * поток, добавляющий в LinkedBlockingQueue не блокировался.
 */
class ThreadPool(numOfThreads: Int, maxNumOfTask: Int = 10000) : Executor {

    private val tasks: BlockingQueue<Runnable>
    private val threads: MutableList<WorkerThread>
    private var isStopped: Boolean
    private val lock: ReentrantLock

    init {
        require(numOfThreads > 0)
        tasks = LinkedBlockingQueue(maxNumOfTask)
        threads = ArrayList(numOfThreads)
        for (i in 1..numOfThreads) {

            threads.add(WorkerThread(tasks, "worker #$i"))
            threads.last().start()
        }
        lock = ReentrantLock(true)
        isStopped = false
    }

    /**
     * Добавляет задание в очередь на выполнение.
     * @param command задание
     */
    @Synchronized
    override fun execute(command: Runnable) = lockThenInvoke {
        check(!isStopped) { "ThreadPool is stopped" }
        tasks.put(command)
    }

    /**
     * Завершает работу ThreadPool. Те задачи, которые уже выполняются, будут завершены.
     * Те, которые в очереди, не будут выполнены.
     * @return ответ на вопрос: работает ли сейчас какой-нибудь поток?
     */
    @Synchronized
    fun shutdown(): Boolean {
        val isAnybodyRunning: Boolean
        lock.lock()
        try {
            check(!isStopped) { "ThreadPool has been already stopped" }
            isAnybodyRunning = threads.any() { it.stopWorkerThread() }
            isStopped = true
        } finally {
            lock.unlock()
        }
        return isAnybodyRunning
    }

    private fun lockThenInvoke(block: () -> Unit) {
        lock.lock()
        try {
            block()
        } finally {
            lock.unlock()
        }
    }

//    /**
//     * Ожидает пока все задачи будут выполнены и завершает работу ThreadPool.
//     */
//    @Synchronized
//    fun softShutdown() = lockThenInvoke {
//        check(!isStopped) { "ThreadPool has been already stopped" }
//        while (!tasks.isEmpty()) {
//            try {
//                Thread.sleep(10)
//            } catch (ex: Exception) {
//                println(ex.stackTrace)
//            }
//        }
//
//        threads.forEach { it.stopWorkerThread() }
//
//        while (threads.any { it.isAlive }) {
//            try {
//                Thread.sleep(10)
//            } catch (ex: Exception) {
//                println(ex.stackTrace)
//            }
//        }
//        isStopped = true
//    }

}