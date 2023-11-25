package com.demo.mvvmdaggerkotlindemo.utils

class Path2D {
    fun getPossibleWays(points: Array<Array<Int>>): Int {
        val rows = points.size
        val columns = points[0].size
        val visited = Array(rows) { BooleanArray(columns) }

        fun isValid(x: Int, y: Int): Boolean {
            return x in 0 until rows && y in 0 until columns && points[x][y] == 0 && !visited[x][y]
        }

        fun explorePath(x: Int, y: Int): Int {
            if (x == rows - 1 && y == columns - 1) {
                return 1
            }

            visited[x][y] = true
            val directions = arrayOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

            var paths = 0

            for (dir in directions) {
                val newX = x + dir.first
                val newY = y + dir.second

                if (isValid(newX, newY)) {
                    paths += explorePath(newX, newY)
                }
            }

            visited[x][y] = false
            return paths
        }

        return explorePath(0, 0)
    }

    fun main() {
        val points = arrayOf(
            arrayOf(0, 0),
            arrayOf(0, 0)
        )

        val ways = getPossibleWays(points)

        println("Number of possible ways: $ways")
    }

}