package Shapes

class Rectangle(val width:Int, val height:Int) {
    val isSqared: Boolean
        get() = width==height
}