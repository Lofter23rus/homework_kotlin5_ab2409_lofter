package ru.otus.cars

// Топливная система - включает в себя горловину и бак (как наследника бака)
abstract class TankMouth(val value: FuelType): Tank {
    init {
        println("Тип топливной системы: ${value}")
    }
    // Допустимый тип топлива
    val fuelType: FuelType = value
    // Текущий объем топлива (литры)
    var currentFuel: Int = 0
    // Открыть
    fun open() {
        println("Горловина открыта")
    }
    // Закрыть
    fun close() {
        println("Горловина закрыта")
    }
    // текущий остаток топлива
    override fun getContenst() : Int {
        return this.currentFuel
    }
    // заправка топливом
    override fun reciveFuel(liters: Int) {
        this.currentFuel += liters
    }
}

class CustomException(message: String) : Exception(message)

// Топливная система на бензине
class PetrolMouth : TankMouth(FuelType.PETROL) {
    // Заправка бензином
    fun fuelPetrol(liters: Int) {
        if (fuelType != FuelType.PETROL) {
            throw CustomException("Недопустимый тип топлива")
        }
        // Открыть бак
        this.open()
        // Заправим бак
        this.reciveFuel(liters)
        println("заправлено: ${liters}, всего в баке ${this.currentFuel}")
        // Закрыть бак
        this.close()
    }
}

// Топливная система на сжиженном газе
class LpgMouth : TankMouth(FuelType.LPG) {
    fun fuelLpg(liters: Int) {
        if (fuelType != FuelType.LPG) {
            throw CustomException("Недопустимый тип топлива")
        }
        // Открыть бак
        this.open()
        // Заправим бак
        this.reciveFuel(liters)
        println("заправлено: ${liters}, всего в баке ${this.currentFuel}")
        // Закрыть бак
        this.close()
    }
}

