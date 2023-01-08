package Colors

enum class useEnum(val r:Int, val g:Int, val b:Int) {
    RED(255,0,0),BLUE(0,0,255),GREEN(0,255,0);
    fun rgb() = println("r : $r g : $g  b : $b")

}