package projectEuler.task016

import utils.Benchmark
import java.math.BigInteger

/*  Task016
    2^15 = 32768, сумма цифр этого числа равна 3 + 2 + 7 + 6 + 8 = 26.  Какова сумма цифр числа 2^1000?
*/

private val degree = 1000

fun main() {
    val bench = Benchmark()
    var a = BigInteger.TWO

    a = a.pow(degree)

    a.toString()

    println(a.toString())
    bench.printBenchmark()
}