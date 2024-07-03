package projectEuler.task015

import utils.Benchmark

/*  Task015
    Пути через таблицу
    Начиная в левом верхнем углу сетки 2×2 и имея возможность двигаться только вниз или вправо,
    существует ровно 6 маршрутов до правого нижнего угла сетки.
     Сколько существует таких маршрутов в сетке 20×20?
*/
private const val gridSize = 20

fun main() {
    val bench = Benchmark()
    val grid = createGrid(gridSize + 1, gridSize + 1, 1L)

    for (i in gridSize - 1 downTo 0) {
        for (j in gridSize - 1 downTo 0) {
            grid[i][j] = grid[i + 1][j] + grid[i][j + 1]
        }
    }

//    grid.forEach {
//        it.forEach { i -> print("$i ") }
//        println()
//    }

    println("Total : ${grid[0][0]}")
    bench.printBenchmark()
}


inline fun <reified T : Number> createGrid(rows: Int, cols: Int, default: T): Array<Array<T>> {
    return Array(rows) {
        Array(cols) {
            default
        }
    }
}

//inline fun <reified T : Number> createGrid(rows: Int, cols: Int, block: (i: Int, j: Int) -> T): Array<Array<T>> {
//    return Array(rows) { i ->
//        Array(cols) { j ->
//            block(i, j)
//        }
//    }
//}