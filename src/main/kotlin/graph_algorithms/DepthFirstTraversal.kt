package graph_algorithms

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException
import java.util.Stack

fun main() {
    try {
        val file = File("depthFirstTraversal.in")
        if (file.exists()) {
            val reader = FileReader(file)
            val buffer = BufferedReader(reader)

            val rows = buffer.readLine().toInt()
            val columns = buffer.readLine().toInt()

            val matrix = Array(rows) { IntArray(columns) }

            for (i in 0 until rows) {
                // creating a list of the matrix edges
                val edges = buffer.readLine().split(" ")
                for (j in edges.indices) {
                    val edge = edges[j].toInt()
                    matrix[i][j] = edge
                }
            }
            println("------------- Iterative Depth First Traversal--------------------------")
            depthFirstTraversal(matrix[0][0], matrix)
            println()
            println("------------- Recursive Depth First Traversal--------------------------")
            recursiveDepthFirstTraversal(matrix[0][0], matrix)
        } else {
            file.createNewFile()
        }
    } catch (e: IOException) {
        println(e.message)
    }
}

fun recursiveDepthFirstTraversal(i: Int, matrix: Array<IntArray>) {
    //printing out the current node being traversed
    print("$i ---> ")
    for (j in 0 until matrix[i].size){
        if (matrix[i][j] == 1){
            recursiveDepthFirstTraversal(j, matrix)
        }
    }
}

