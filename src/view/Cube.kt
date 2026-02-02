package view

object Cube : Model {

    override val vs = arrayOf(
        Point3(x = 0.25, y = 0.25, z = 0.25),
        Point3(x = -0.25, y = 0.25, z = 0.25),
        Point3(x = -0.25, y = -0.25, z = 0.25),
        Point3(x = 0.25, y = -0.25, z = 0.25),

        Point3(x = 0.25, y = 0.25, z = -0.25),
        Point3(x = -0.25, y = 0.25, z = -0.25),
        Point3(x = -0.25, y = -0.25, z = -0.25),
        Point3(x = 0.25, y = -0.25, z = -0.25),
    )

    override val fs = arrayOf(
        arrayOf(0, 1, 2, 3),
        arrayOf(4, 5, 6, 7),
        arrayOf(0, 4),
        arrayOf(1, 5),
        arrayOf(2, 6),
        arrayOf(3, 7),
    )
}