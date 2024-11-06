package ru.otus.cars

fun main() {
    println("\n===> drive cars...")
    driveCars() // Запускаем функцию для проверки вождения

    println("\n===> inner test...")
    innerNestedCheck() // Проверка внутреннего состояния

    println("\n===> garage make...")
    garageMake() // Создание машины в гараже

    println("\n===> model special...")
    // Дополнительные действия для проверки моделей (можно добавить сюда, если нужно)

    println("\n===> get equipment...")
    getEquipment() // Проверка оборудования

    println("\n===> get color...")
    getColor() // Проверка цвета

    println("\n===> tech checks...")
    techChecks() // Проверка технического состояния

    println("\n===> fuel tests...")
    fuelTestDemo() // Тестирование системы заправки

    println("\n===> Taz...")
    println(Taz.color)
}

fun driveCars() {
    val vaz1 = Togliatti.buildCar(Vaz2107, Car.Plates("123", 77))
    val vaz2 = Togliatti.buildCar(Vaz2108, Car.Plates("321", 78))

    println("Экземпляры класса имеют разное внутреннее состояние:")
    vaz1.wheelToRight(10)
    println(vaz1.toString()) // Выводит 10 и случайную скорость
    vaz2.wheelToLeft(20)
    println(vaz2.toString()) // Выводит -20 и случайную скорость
}

fun fuelTestDemo() {
    val vaz1 = Togliatti.buildCar(Vaz2107, Car.Plates("123", 77))
    val vaz2 = Togliatti.buildCar(Vaz2108, Car.Plates("321", 78))

    fuelTest(vaz1, 30)
    fuelTest(vaz2, 40)
}

fun fuelTest(car: Car, liters: Int) {
    println("Текущий уровень топлива для ${car::class.simpleName}: ${car.carOutput.getFuelContents()} литров.")
    when (val mouth = car.tankMouth) {
        is PetrolMouth -> {
            println("Заправляем бензином...")
            mouth.fuelPetrol(car.tank, liters)
        }
        is LpgMouth -> {
            println("Заправляем газом...")
            mouth.fuelLpg(car.tank, liters)
        }
    }
    println("Уровень топлива после заправки: ${car.carOutput.getFuelContents()} литров.")
}

fun innerNestedCheck() {
    val vaz = Vaz2107.build(Car.Plates("123", 77))
    val output = vaz.VazOutput()

    println("Скорость до проверки: ${output.getCurrentSpeed()}")
    Vaz2107.test(vaz)
    println("Скорость после проверки: ${output.getCurrentSpeed()}")
}

fun garageMake() {
    val maker = "Дядя Вася"
    val garage = object : CarFactory {
        override fun buildCar(builder: CarBuilder, plates: Car.Plates): Car {
            println("Запил Жигулей у: $maker...")
            println("Машину не проверяем... и в продакшн...")
            return builder.build(plates)
        }
    }

    val vaz = garage.buildCar(Vaz2107, Car.Plates("500", 50))
    println(vaz.toString())
}

fun getEquipment() {
    val cars = listOf(
        Vaz2107.build(Car.Plates("123", 77)),
        Vaz2108.build(Car.Plates("321", 78))
    )

    cars.forEach { car ->
        println("Оборудование: ${car.getEquipment()}")
    }
}

fun getColor() {
    val cars = listOf(
        Vaz2107.build(Car.Plates("123", 77)),
        Vaz2108.build(Car.Plates("321", 78))
    )

    cars.forEach { car ->
        println("Цвет: ${car.color}")
    }
}

fun techChecks() {
    val vaz1 = Vaz2107.build(Car.Plates("123", 77))
    val vaz2 = Vaz2108.build(Car.Plates("321", 78))

    repairEngine(vaz1)
    repairEngine(vaz2)
}

fun repairEngine(car: VazPlatform) {
    when (car.engine) {
        is VazEngine.LADA_2107 -> println("Чистка карбюратора у двигателя объемом ${car.engine.volume} куб.см у машины $car")
        is VazEngine.SAMARA_2108 -> println("Угол зажигания у двигателя объемом ${car.engine.volume} куб.см у машины $car")
    }
}
