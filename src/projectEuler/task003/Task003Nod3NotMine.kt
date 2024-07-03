package projectEuler.task003

import utils.Benchmark
import kotlin.math.sqrt

//Наибольший простой делитель
//Простые делители числа 13195 - это 5, 7, 13 и 29.
//
//Каков самый большой делитель числа 600851475143, являющийся простым числом?

private var numMax = 600851475143
private var c = 1L

fun main() {
    val benchmark = Benchmark()
    while (numMax > 1) {
        c++
        if (isSimpleNum(c)) {
            while (numMax % c == 0L) {
                numMax /= c
            }
        }
    }

    println("$c it is simple ")
    benchmark.printBenchmark()
}

// not work with num < 10
private fun isSimpleNum(num: Long): Boolean {
    for (i in 2 until sqrt(num.toDouble()).toLong()) {
        if (num % i == 0L) {
            return false
        }
    }
    return true
}
