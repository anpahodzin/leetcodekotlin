package notmine

fun main() {
    val list = listOf("ass", "shit", "shit", "shit", "ass", "ass", "poop", "shit", "shit", "shit")

    val groupedList = list.groupBy { it }
    val sortedList = groupedList.map { it.value }

    println(groupedList)
    println("")
    println(sortedList)
}