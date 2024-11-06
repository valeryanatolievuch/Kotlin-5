package ru.otus.cars
interface TankMouth {
    fun open()
    fun close()
}
class PetrolMouth : TankMouth {
    override fun open() { println("Открытие горловины для бензина...") }
    override fun close() { println("Закрытие горловины для бензина...") }

    fun fuelPetrol(tank: Tank, liters: Int) {
        open()
        tank.receiveFuel(liters)
        close()
    }
}
class LpgMouth : TankMouth {
    override fun open() { println("Открытие горловины для газа...") }
    override fun close() { println("Закрытие горловины для газа...") }

    fun fuelLpg(tank: Tank, liters: Int) {
        open()
        tank.receiveFuel(liters)
        close()
    }
}