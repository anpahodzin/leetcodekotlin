package utils

class Benchmark {
    private val startTimeNs = System.nanoTime()

    fun printBenchmark() {
        println("Benchmark: completed in ${(System.nanoTime() - startTimeNs) / 1_000_000F} ms")
    }
}

fun nanoBenchmark(startTimeNs: Long = System.nanoTime(), block: () -> Unit, finish: (durationNs: Long) -> Unit) {
    block.invoke()
    finish.invoke(System.nanoTime() - startTimeNs)
}

fun nanoBenchmark(startTimeNs: Long = System.nanoTime(), block: () -> Unit) {
    nanoBenchmark(startTimeNs, block, finish = { durationNs ->
        println("Benchmark: completed in ${durationNs / 1_000_000F} ms")
    })
}