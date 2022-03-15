package ru.tinkoff.fintech.homework2

/**
 * Вынес в отдельный интерфейс, чтобы через интерфейсы Queue и Stack
 * могли узнавать size и capacity. Не сделал этот интерфейс generic-ом,
 * потому что в данный момент он не нужен
 */
interface Collection {
    val capacity: Int
    val size: Int
}