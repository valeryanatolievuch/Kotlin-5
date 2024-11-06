package ru.otus.cars

object Taz: Car {
    /**
     * Номерной знак
     */
    override val plates: Car.Plates = Car.Plates("Без номера", 0)

    /**
     * Цвет машины
     */
    override val color: String = "Ржавый"

    /**
     * Следит за машиной
     */
    override val carOutput: CarOutput = object : CarOutput {
        override fun getCurrentSpeed(): Int = 0
        override fun getFuelContents(): Int = 0
    }
    override val tankMouth: TankMouth = object : TankMouth {
        override fun open() {
            println("У Taz нет настоящей горловины бака.")
        }
        override fun close() {
            println("У Taz нет настоящей горловины бака.")
        }
    }
    override val tank: Tank = Tank(0)

    /**
     * Получить оборудование
     */
    override fun getEquipment(): String = "Крыса"

    /**
     * Руль вправо на [degrees] градусов
     */
    override fun wheelToRight(degrees: Int) {
        println("Руля нет")
    }

    /**
     * Руль влево на [degrees] градусов
     */
    override fun wheelToLeft(degrees: Int) {
        println("Руля нет")
    }
}
