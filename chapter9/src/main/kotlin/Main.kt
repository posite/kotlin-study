//제네릭 확장 프로퍼티
//val <T> List<T>.penultimate: T
//    get() = this[size - 2]

fun main(args: Array<String>) {
//    val readers : MutableList<String> = mutableListOf()
//    val readers = mutableListOf<String>()

    val letters = ('a'..'z').toList()
    println(letters.slice(0..2))
//    println(listOf(3, 4, 5, 6).penultimate)

    fun <T : Number> oneHalf(value: T): Double {
        return value.toDouble() / 2.0
    }
    println(oneHalf(3L))

    fun <T : Comparable<T>> max(first: T, second: T): T {
        return if (first > second) first else second
    }
    println(max("5","4"))

    class Processor<T: Any>{
        fun process(value: T){
            value.hashCode()
        }
    }
    
}

