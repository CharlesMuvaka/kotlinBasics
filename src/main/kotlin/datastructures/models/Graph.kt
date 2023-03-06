package datastructures.models

import java.util.*

class Graph(private val vertices: Int) {
    val matrix = Array(vertices){IntArray(vertices)}

    //method to add graph edges in the matrix
    fun addGraphEdges(i: Int, j: Int, k: Int){
        matrix[i][j] = k
    }

    //method to perform a depth first traversal
    fun depthFirstTraversal(startNode: Int){
        //initialising a stack to store the graph nodes to be traversed
        val stack = Stack<Int>()



    }
}