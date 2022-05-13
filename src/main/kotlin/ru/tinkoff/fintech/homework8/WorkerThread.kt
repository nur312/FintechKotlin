package ru.tinkoff.fintech.homework8

import java.util.concurrent.BlockingQueue

/**
 * Thread для выполнения задач.
 */
class WorkerThread(private val tasks: BlockingQueue<Runnable>, name: String) : Thread(name) {
    /**
     * Поле для сохранения текущего потока, который выполняет задачу.
     * Нужен для прерывания потока, если он находиться в режиме ожидания.
     */
    private lateinit var workerThread: WorkerThread

    /**
     * Индикатор завершения потока.
     */
    @Volatile
    private var isStopped = false


    override fun run() {
        workerThread = currentThread() as WorkerThread
        while (!isStopped) {
            try {

                val task = tasks.take()


                if (!isStopped) {
                    task.run()
                }
            } catch (_: InterruptedException) {
//                println("$name was interrupted")
            }
        }
//        println("Thread $name finished")

    }

    /**
     *  Ставим признак, что поток должен быть завершен, и прерываем потоки, если вдруг они находятся в режиме ожидания.
     */
    @Synchronized
    fun stopWorkerThread(): Boolean {
        check(!isStopped) { "You can stop only once" }
        isStopped = true
        if (workerThread.state == State.WAITING) {
            workerThread.interrupt()
            return true
        }
        return false
    }


}