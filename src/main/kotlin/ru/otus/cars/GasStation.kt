package ru.otus.cars

import ru.otus.cars.Taz.tankMouth
import kotlin.random.Random

// АЗС, заправляет любым топливом
class GasStation {
    // заправка машины топливом
    fun fuelCar(car: Car) {
        // защищенный блок, процесс заправки НЕ должен "взрываться"
        try {
            println("Топлива до заправки: ${car.carOutput.getFuelContents()}")
            when (car.tankMouth.fuelType) {
                FuelType.PETROL -> fuelPetrol(car.tankMouth as PetrolMouth, Random.nextInt(0, 100))
                FuelType.LPG -> fuelLpg(car.tankMouth as LpgMouth, Random.nextInt(0, 100))
            }
            println("Топлива после заправки: ${car.carOutput.getFuelContents()}")
        } catch (t: Throwable) {
            println("Ошибка: ${t.message}")
        }

    }
    // заправка именно бензином, снаружи НЕ доступна
    private fun fuelPetrol(tankMouth: PetrolMouth, liters: Int) {
        tankMouth.fuelPetrol(liters)
    }
    // заправка именно сжиженным газом, снаружи НЕ доступна
    private fun fuelLpg(tankMouth: LpgMouth, liters: Int) {
        tankMouth.fuelLpg(liters)
    }

    fun showCarsInfo(cars: List<Car>){
        cars.forEach { car: Car -> println(car.getEquipment())
        }
    }

    // заправка нескольких машин топливом
    fun fuelCars(carList: List<Car>) {
        println("")
        println("Инфо до заправки")
        println("-------------------------------------------------------------------------")
        showCarsInfo(cars = carList)
        println("-------------------------------------------------------------------------")
        println("Заправка")
        for(car: Car in carList){
            fuelCar(car)
        }
        println("-------------------------------------------------------------------------")
        println("Инфо после заправки")
        showCarsInfo(cars = carList)
    }
}