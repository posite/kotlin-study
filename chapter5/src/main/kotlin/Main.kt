class Person(val name: String, val age: Int)
class Book(val title: String, val authors: List<String>)

fun main(args: Array<String>) {
    val people = listOf(Person("Alice", 24), Person("Bob", 31), Person("Clare", 31))
    println(people.maxByOrNull { p: Person -> p.age }!!.name)
    println(people.maxByOrNull { it.age }!!.name)

    val names = people.joinToString(" ") { p: Person -> p.name }
    println(names)
    val mis = { x: Int, y: Int -> x - y }
    println(mis(3, 4))

    fun Person.isAdult() = age >= 20
    val predicate = Person::isAdult
    println(predicate(people[0]))

    val list = listOf(1, 2, 3, 4, 5, 6)
    println(list.filter { it % 3 == 0 })
    println(list.map { it * 4 })

    val numbers = mapOf(0 to "zero", 1 to "one")
    println(numbers.mapValues { it.value.uppercase() })

    val canBeInClub27 = { p: Person -> p.age <= 27 }
    println(people.all { canBeInClub27(it) })
    println(people.any { canBeInClub27(it) })
    println(people.count { canBeInClub27(it) })
    println(people.find { canBeInClub27(it) }!!.name)
    println(people.groupBy { it.age })

    val strings = listOf("aka", "ckc")
    println(strings.flatMap { it.toList() })

    people.asSequence()
        .map(Person::name)
        .filter { it.startsWith('A') }
        .toList()

    println(
        listOf(1, 2, 3, 4).asSequence()
            .map { print("map($it) "); it * it }
            .filter { print("filter($it) "); it % 2 == 0 }
            .first()
    )

    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo50 = naturalNumbers.takeWhile { it <= 10 }
    println(numbersTo50.sum())

    //    fun aplphabet(): String{
//        val stringBuilder = StringBuilder()
//        return with(stringBuilder){
//            for(letter in 'A'..'Z'){
//                this.append(letter)
//            }
//            append("\n Now I know the alphabel!")
//            this.toString()
//        }
//    }
//    fun alphabet() = with(StringBuilder()) {
//        for (letter in 'A'..'Z') {
//            append(letter)
//        }
//        append("\n Now I know the alphabel!")
//        this.toString()
//    }
    fun alphabet() = StringBuilder().apply {
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\n Now I know the alphabel!")
    }.toString()
    println(alphabet())
}
