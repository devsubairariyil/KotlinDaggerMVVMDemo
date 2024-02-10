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
fun updateAppKey(newAppKey: String) {
    val file = File("/sdcard/MyAppData/config.xml")

    // Create a FileInputStream to read the file
    val fileInputStream = FileInputStream(file)

    // Create an XmlPullParser
    val parser = Xml.newPullParser()
    parser.setInput(fileInputStream, null)

    // Create a StringBuilder to store the updated XML content
    val updatedXml = StringBuilder()

    while (parser.next() != XmlPullParser.END_DOCUMENT) {
        when (parser.eventType) {
            XmlPullParser.START_TAG -> {
                // Check if it's the tag you want to update
                if (parser.name == "AppKey") {
                    // Replace the old value with the new one
                    updatedXml.append("<${parser.name}>$newAppKey</${parser.name}>")
                } else {
                    // Keep other tags as they are
                    updatedXml.append("<${parser.name}>")
                }
            }
            XmlPullParser.END_TAG -> {
                updatedXml.append("</${parser.name}>")
            }
            XmlPullParser.TEXT -> {
                updatedXml.append(parser.text)
            }
        }
    }

    // Close the FileInputStream
    fileInputStream.close()

    // Write the updated XML back to the file
    val fileOutputStream = FileOutputStream(file)
    fileOutputStream.write(updatedXml.toString().toByteArray())
    fileOutputStream.close()
}