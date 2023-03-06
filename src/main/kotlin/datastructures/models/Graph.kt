package datastructures.models

class Graph(private val vertices: Int) {
    val matrix = Array(vertices){IntArray(vertices)}

    fun addGraphEdges(i: Int, j: Int, k: Int){
        matrix[i][j] = k
    }
}