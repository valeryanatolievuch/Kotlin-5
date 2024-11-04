package ru.otus.cars

abstract class VazPlatform(override val color: String) : Car {
    // Положение руля. Доступно только внутри класса и наследникам
    protected var wheelAngle: Int = 0 // Положение руля

    // Реализация интерфейса CarInput
    override fun wheelToRight(degrees: Int) { wheelAngle += degrees }
    // Реализация интерфейса CarInput
    override fun wheelToLeft(degrees: Int) { wheelAngle -= degrees }

    override val tankMouth: TankMouth = object : TankMouth {
        private var isOpen = false

        override fun open() {
            isOpen = true
            println("Горловина бака открыта.")
        }

        override fun close() {
            isOpen = false
            println("Горловина бака закрыта.")
        }
    }

    override val tank: Tank = Tank(capacity = 50).apply {
        mouth = tankMouth
    }
    // Получить оборудование
    override fun getEquipment(): String = "Кузов, колеса, движок"

    // Абстрактное свойство двигателя
    abstract val engine: VazEngine
}

// Перечисление двигателей ВАЗ
sealed class VazEngine {
    // Объем двигателя можно задать при производстве
    abstract val volume: Int

    data class LADA_2107(override val volume: Int) : VazEngine()
    data class SAMARA_2108(override val volume: Int) : VazEngine()
}