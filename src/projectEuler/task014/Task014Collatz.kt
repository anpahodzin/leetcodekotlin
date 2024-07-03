package projectEuler.task014

import utils.Benchmark

/*
    Задача 14
    Самая длинная последовательность Коллатца
Следующая повторяющаяся последовательность определена для множества натуральных чисел:

n → n/2 (n - четное)
n → 3n + 1 (n - нечетное)

Используя описанное выше правило и начиная с 13, сгенерируется следующая последовательность:

13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
Получившаяся последовательность (начиная с 13 и заканчивая 1) содержит 10 элементов.
Хотя это до сих пор и не доказано (проблема Коллатца (Collatz)), предполагается,
что все сгенерированные таким образом последовательности оканчиваются на 1.

Какой начальный элемент меньше миллиона генерирует самую длинную последовательность?

Примечание: Следующие за первым элементы последовательности могут быть больше миллиона.*/

private const val count = 1_000_000

fun main() {
    val bench = Benchmark()
    var firstElement = 1
    var maxList = emptyList<Int>()
    while (firstElement < count) {
        firstElement++
        val list = generateCollatzNumbers(firstElement)
//        println(" $firstElement size ${maxList.size} => $list")
        if (list.size > maxList.size) {
            println()
            println(" $firstElement size ${maxList.size} => $list")
            maxList = list
        }
    }
    println()
    println(" Total: $firstElement => size ${maxList.size} => $maxList")
    bench.printBenchmark()
}

fun getCollatzNumbers(count: Int): Int {
    var value = 1
    var n = count
    while (n > 1) {
        value++
        if (n % 2 == 0) {
            n /= 2
        } else {
            n = 3 * n + 1
        }
    }
    return value
}

fun generateCollatzNumbers(count: Int): List<Int> {
    var list = mutableListOf<Int>()
    var n = count
    while (n > 1) {
        list.add(n)
        if (n % 2 == 0) {
            n /= 2
        } else {
            n = 3 * n + 1
        }
    }
    list.add(n)
    return list
}