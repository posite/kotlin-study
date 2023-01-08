package typecast

class ExprEx {
    interface Expr
    class Num(val value:Int):Expr
    class Sum(val leftExpr:Expr, val rightExpr: Expr) : Expr
    fun eval(e: Expr): Int=
        when(e){
            is Num-> e.value
            is Sum-> eval(e.leftExpr)+eval(e.rightExpr)
            else->throw IllegalArgumentException("")
        }
    val result = println(eval(Sum(Sum(Num(1),Num(2)),Num(7))))
}