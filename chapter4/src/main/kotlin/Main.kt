/*4장 클래스, 객체, 인터페이스

final - 오버라이드 불가
open - 오버라이드 가능
abstract - 반드시 오버라이드 해야함
override - 상위 클래스나 인터페이스의 멤버를 오버라이드함을 의미

가시성
public    모든곳에서 볼 수 있음
internal  같은 모듈 안에서만 볼 수 있음
protected 하위 클래스만 볼 수 있음
private   같은 클래스만 볼 수 있음
* */

/*
봉인된 클래스 -> 장점 : 상위 클래스 Expr을 상속한 하위 클래스 Num, Sum의 정의를 제한 할 수 있다
=> eval()의 when에서 default 분기가 필요없어진다
 */
sealed class Expr{
    class Num(val value:Int): Expr()
    class Sum(val leftExpr:Expr, val rightExpr: Expr): Expr()
}
fun eval(e:Expr): Int{
    return when(e){
        is Expr.Num->{
            e.value
        }
        is Expr.Sum->{
            eval(e.rightExpr)+eval(e.leftExpr)
        }
    }
}

/*
프로퍼티의 접근자 가시성을 변경 가능
 */
open class LengthCounter{
    //counter의 세터를 private으로 변경 -> 이 클래스에서만 접근 가능
    var counter : Int =0
        private set
    fun addWord(word: String){
        counter += word.length
        println(counter)
    }
}

/*
클래스 위임하기
상속을 허용하지 않는 클래스으에 새로운 동작등을 추가 할 때 사용
데코레이터가 새로운 기능을 제공하고 기존의 기능은 기존 클래스의 메서드에게 요청을 전달한다
by 키워드로 위임한 후 변경할 메서드만 변경하면 된다 -> 수많은 코드 준비를 안해도 된다
 */
class CountingSet<T>(
    val innerSet : MutableCollection<T> = HashSet<T>()
):MutableCollection<T> by innerSet{
    var objectAdded = 0
    override fun add(element: T): Boolean {
        objectAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        objectAdded += elements.size
        return innerSet.addAll(elements)
    }
}
/*
코틀린에서는 클래스의 유일한 객체를 저장하는 싱글턴 패턴을 객체 선언 기능을 통해 지원
object ~~~{

}
동반 객체 : 클래스의 인스턴스와 상관없이 클래스 내부 정보에 접근해야 하는 함수가 필요할 때 중첩된 객체 선언의 멤버 함수로 정의하는데 팩토리 메서드가 대표적이며
companion이라는 표시를 붙이면 동반 객체를 만들 수 있어 자바의 정적 메서드 호출이나 정적 필드 사용 구문과 같아짐
동반 객체에 확장도 가능하다
 */
class A{
//  동반객체 생성
    companion object{
        fun bar(){
            println("companion object called")
        }
    }
}


fun main(args: Array<String>) {
    val len = LengthCounter()
    len.addWord("dd")
    len.addWord("draw")
    A.bar()
//    이 코드는 counter의 세터가 private이므로 컴파일 에러
//    len.counter = 16

}