package com.demo.mvvmdaggerkotlindemo.utils

class Path2D {
    fun getPossibleWays(points: Array<Array<Int>>): Int {
        val rows = points.size
        val columns = points[0].size
        val dp = Array(rows) { IntArray(columns) }

        // Initialize the top-left corner
        dp[0][0] = if (points[0][0] == 0) 1 else 0

        // Initialize the first row
        for (col in 1 until columns) {
            dp[0][col] = if (points[0][col] == 0) dp[0][col - 1] else 0
        }

        // Initialize the first column
        for (row in 1 until rows) {
            dp[row][0] = if (points[row][0] == 0) dp[row - 1][0] else 0
        }

        // Fill the DP table
        for (row in 1 until rows) {
            for (col in 1 until columns) {
                if (points[row][col] == 0) {
                    dp[row][col] = dp[row - 1][col] + dp[row][col - 1]
                } else {
                    dp[row][col] = 0
                }
            }
        }

        // The bottom-right corner contains the result
        return dp[rows - 1][columns - 1]

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