import Colors.useEnum
import Shapes.Rectangle
import typecast.ExprEx

fun main(args: Array<String>) {
    println("Hello World!")
    //일반클래스 사용하기
    println("클래스 사용하기")
    val rec = Rectangle(10, 10)
    println("This rectangle is ${rec.isSqared}\n")

    //enum 클래스 사용하기
    val color = useEnum.BLUE
    color.rgb()
    fun findColor(color: useEnum) =
        when (color) {
            useEnum.BLUE -> println("BLUE")
            useEnum.GREEN -> println("GREEN")
            useEnum.RED -> println("RED")
            else -> println("nothing")
        }
    findColor(color)
    println()

    //스마트 캐스트 : 타입 검사와 타입 캐스트 조합
    val type = ExprEx()
    type.result
}