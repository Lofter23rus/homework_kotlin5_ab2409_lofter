package ru.otus.cars

/**
 * Следит за машиной
 */
interface CarOutput : Tank {
    /**
     * Скажи текущую скорость
     */
    fun getCurrentSpeed(): Int
    // Остаток в баке
    fun getFuelContents() : Int
}