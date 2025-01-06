package ru.otus.cars

/**
 * Машина целиком
 */
interface Car : CarInput {
    /**
     * Номерной знак
     */
    // в задании именно CarPlates (никак не Plates)
    val plates: CarPlates

    /**
     * Цвет машины
     */
    val color: String

    /**
     * Следит за машиной
     */
    val carOutput: CarOutput

    /**
     * Получить оборудование
     */
    fun getEquipment(): String

    /**
     * Внутренний статический класс - номерой знак
     */
    data class CarPlates(val number: String, val region: Int)

    // горловина бака
    val tankMouth: TankMouth
}