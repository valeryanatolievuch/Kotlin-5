package ru.otus.cars
class Tank(private val capacity: Int) {

    var mouth: TankMouth? = null

    private var currentFuelLevel: Int = 0
    fun getContents(): Int {
        return currentFuelLevel
    }
    fun receiveFuel(liters: Int) {
        if (liters < 0) {
            println("Ошибка: Нельзя добавить отрицательное количество топлива.")
            return
        }

        currentFuelLevel = (currentFuelLevel + liters).coerceAtMost(capacity)
        println("В бак добавлено $liters литров топлива. Текущий уровень: $currentFuelLevel литров.")
    }
}
