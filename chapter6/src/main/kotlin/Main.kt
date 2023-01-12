lateinit var tree: String


fun main(args: Array<String>) {
    data class Person(val name: String, val age: Int? = null) {
        fun isOlderThan(other: Person): Boolean? {
            if (age == null || other.age == null) {
                return null
            }
            return age > other.age
        }
    }
    println(Person("Sam", 35).isOlderThan(Person("Amy", 42)))
    println(Person("Sam", 35).isOlderThan(Person("Jane")))
    //    println(tree)
    fun printAllCaps(s: String?) {
        val allCaps: String? = s?.toUpperCase()
//        val len : Int = s?.length
        println(allCaps)
    }

    fun foo(s: String?) {
        val t: String = s ?: "empty"
        println(t)
    }

    fun change(o: Any?) {
        val name = o as? String ?: "not String!!"
        println(name)
    }

    fun exact(s: String?) {
        val exactS = s!!
        println(exactS.length)
    }

    var email: String? = "su84053@gmail.com"
    email?.let { println(it) }

//    exact(null)
    change(22)
    foo(null)
    printAllCaps("name")
    printAllCaps(null)
    val i :Int = 0
    val j : Long = i.toLong()

    fun fail(message: String): Nothing{
        throw IllegalStateException(message)
    }
    val address = email ?: fail("no email address")

    val source : Collection<Int> = arrayListOf(1,2,3,4)
    val dest : MutableCollection<Int> = arrayListOf()
    dest.addAll(source)
}