enum class Delivery { STANDARD, EXPEDITED }

fun main(args: Array<String>) {
    val sum: (Int, Int) -> Int = { x, y -> x + y }
//  val sum = {x:Int, y:Int -> x+y}

    fun twoAndThree(operation: (Int, Int) -> Int) {
        val result = operation(2, 3)
        println("The result is $result")
    }
    twoAndThree { a, b -> a + b }
    twoAndThree { a, b -> a * b }

    class Order(val itemCount: Int)

    fun getShippingCostCalculator(delivery: Delivery): (Order) -> Double {
        if (delivery == Delivery.EXPEDITED) {
            return { order -> 6 + 2.1 * order.itemCount }
        }
        return { order -> 1.2 * order.itemCount }
    }

    val calc = getShippingCostCalculator(Delivery.EXPEDITED)
    println(calc(Order(4)))

    data class Person(val name: String, val age: Int)

    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    fun lookForAlice(people: List<Person>) {
        people.forEach   {
            if (it.name == "Alice") {
                println("Found!")
                return@forEach
            }
            println("Alice is not found")
        }
    }
    lookForAlice(people)
}
