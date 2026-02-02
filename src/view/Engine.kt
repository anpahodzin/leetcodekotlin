package view

import java.awt.BasicStroke
import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.Timer
import kotlin.math.cos
import kotlin.math.sin

data class Point(val x: Double, val y: Double)
data class Point3(val x: Double, val y: Double, val z: Double)
class Game(val width: Int = 800, val height: Int = 800, val fps: Int = 60)

fun main() {
    val game = Game()
    val panel = MyPanel(Cube, game)

    val frame = JFrame("JPanel")
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.setSize(game.width, game.height)
    frame.add(panel)
    frame.isVisible = true
}

interface Model {
    val vs: Array<Point3>
    val fs: Array<Array<Int>>
}

class MyPanel(
    val model: Model,
    val game: Game = Game(),
) : JPanel() {

    val dz = 1
    var angle = 0.toDouble()

    init {
        val timer = Timer(2000 / game.fps) {
            val dt = 1 / game.fps.toDouble()
            angle += Math.PI * dt
            repaint()
        }
        timer.start()
    }

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)

        (g as? Graphics2D)?.frame()
    }

    fun Graphics2D.frame() {
        clear()

//        model.vs.forEach { v ->
//            point(screen(project(translateZ(rotateXZ(v, angle), dz))))
//        }

        model.fs.forEach { f ->
            for (i in 0..f.lastIndex) {
                val a = model.vs[f[i]]
                val b = model.vs[f[(i + 1) % f.size]]
                line(
                    screen(project(translateZ(rotateXZ(a, angle), dz))),
                    screen(project(translateZ(rotateXZ(b, angle), dz)))
                )
            }
        }
    }

    private fun Graphics2D.clear() {
        color = Color.BLACK
        fillRect(0, 0, width, height)
    }

    fun Graphics2D.point(p: Point, s: Int = 20, color: Color = Color.WHITE) {
        this.color = color
        fillRect((p.x - s / 2).toInt(), (p.y - s / 2).toInt(), s, s)
    }

    fun Graphics2D.line(p1: Point, p2: Point, s: Int = 2, color: Color = Color.WHITE) {
        stroke = BasicStroke(s.toFloat())
        this.color = color
        drawLine(p1.x.toInt(), p1.y.toInt(), p2.x.toInt(), p2.y.toInt())
    }

    fun screen(p: Point): Point {
        // -1..1 => 0..2 => 0..1 => 0..w
        return Point(
            x = (p.x + 1) / 2 * game.width,
            y = (1 - (p.y + 1) / 2) * game.height,
        )
    }

    fun project(p: Point3): Point {
        return Point(
            x = p.x / p.z,
            y = p.y / p.z,
        )
    }

    fun translateZ(p: Point3, dz: Int): Point3 {
        return Point3(x = p.x, y = p.y, z = p.z + dz)
    }

    fun rotateXZ(p: Point3, angle: Double): Point3 {
        val c = cos(angle)
        val s = sin(angle)
        return Point3(
            x = p.x * c - p.z * s,
            y = p.y,
            z = p.x * s + p.z * c,
        )
    }
}