package notmine

import utils.nanoBenchmark
import kotlin.math.pow

fun main() {

    nanoBenchmark {
        val n = 150

        for (e in 1..n) {
            val e5 = e.toDouble().pow(5.0)

            for (a in 1..n) {
                val a5 = a.toDouble().pow(5.0)
                if (a5 >= e5) break

                for (b in a..n) {
                    val ab = a5 + b.toDouble().pow(5.0)
                    if (ab >= e5) break

                    for (c in b..n) {
                        val abc = ab + c.toDouble().pow(5.0)
                        if (abc >= e5) break

                        for (d in c..n) {
                            val sum = abc + d.toDouble().pow(5.0)

//                            println("$a^5 + $b^5 + $c^5 + $d^5 = $e^5")
//                            println("sum = $sum == e5 = $e5")
                            if (sum == e5) {
                                println("\nANSWER\n")
                                println("$a^5 + $b^5 + $c^5 + $d^5 = $e^5")
                                return@nanoBenchmark
                            }
                            if (sum > e5) break
                        }
                    }
                }
            }
        }

    }
}