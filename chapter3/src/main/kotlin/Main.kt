
//확장 함수 만들기
fun String.lastChar() : Char= this[this.length-1]

//확장 프로퍼티 선언하기
var StringBuilder.firstChar: Char
    get() = get(0)
    set(value: Char) {
        this.setCharAt(0,value)
    }

fun main(args: Array<String>) {

    println("name".lastChar())
    println("name".first())
    println()


    val dkdk = StringBuilder("dkdk")
    dkdk.firstChar = 's'
    println(dkdk)
}