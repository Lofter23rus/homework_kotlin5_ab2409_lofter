package ru.otus.cars

// Бак
interface Tank {
    // Остаток в баке
    fun getContenst() : Int
    // Изменить остаток в баке
    fun reciveFuel(liters: Int)
}