data class Point(var x: Int, var y: Int)
data class Rectangle(val upperLeft: Point, val lowerRight: Point)

operator fun Point.plus(other: Point): Point{
    return Point(x+other.x,y+other.y)
}

fun main(args: Array<String>) {
    operator fun Point.get(index: Int): Int {
        return when(index){
            0 -> x
            1 -> y*2
            else ->
                throw IndexOutOfBoundsException("Invalid coordinate $index choose 0 or 1")
        }
    }
    operator fun Point.set(index: Int, value: Int){
        when(index){
            0 -> x = value
            1 -> y = value
            else ->
                throw IndexOutOfBoundsException("Invalid coordinate $index choose 0 or 1")
        }
    }
    operator fun Rectangle.contains(p:Point):Boolean{
        return p.x in upperLeft.x until lowerRight.x && p.y in upperLeft.y until lowerRight.y
    }
    val rect = Rectangle(Point(100,4),Point(200,8))
    println(Point(150,6) in rect)
    val p = Point(3,4)
    println(p[1])
    p[0]= 100
    println(p[0])
    println(1.rangeTo(3))

    val address = "시흥시 정왕동"
    val (city, dong) = address.split(" ")
    println("시 : $city  동 : $dong")

    fun printEntries(map: Map<String, String>){
        for((key,value) in map){
            println("$key -> $value")
        }
    }
    val map = mapOf("Oracle" to "Java", "Jetbrains" to "Kotlin")
    printEntries(map)
}