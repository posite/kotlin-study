
fun main() {
    fun buildString(
        builderAction: StringBuilder.() -> Unit
    ): String {
        val sb = StringBuilder()
        sb.builderAction()
        return sb.toString()
    }

    val s = buildString { append("Hello")
    append("World")}
}