import kotlin.reflect.*

class Person(
    val name: String,
    val age: Int)

@Target(AnnotationTarget.PROPERTY)
annotation class JsonExclude

@Target(AnnotationTarget.PROPERTY)
annotation class JsonName(val name: String)



fun main(args: Array<String>) {
    val person = Person("Alice", 29)
    val kClass = person.javaClass.kotlin
    println(kClass.simpleName)
    kClass.members.forEach { println(it.name) }

    fun foo(x: Int) = println(x)
    val kFun = ::foo
    kFun.invoke(30)

    fun sum(x: Int, y: Int) = x+y
    val kF2 : KFunction2<Int,Int,Int> = ::sum
    println(kF2.invoke(3,7))


    val kPro = Person::age
    println(kPro.get(person))

}