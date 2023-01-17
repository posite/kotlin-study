interface List<T>{
    operator fun get(index: Int): T
}

class stringList: List<String>{
    override fun get(index: Int): String {
        return this[index]
    }
}
class ArrayList<T>: List<T>{
    override fun get(index: Int): T {
        return this[index]
    }
}

interface Producer<out T>{
    fun produce(): T
}
