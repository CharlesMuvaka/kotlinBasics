package graph_algorithms

import graph_algorithms.models.Graph
import graph_algorithms.models.Node
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException

/*
    Has path problem tries to check whether there exists a path between two nodes of a graph
    It requires a start and a destination.
    We perform traversal until the node being traversed is the destination. If we begin traversing the destination
    node, it means there exists a path from the start to it, otherwise there isn't.
 */

fun main() {
    val nodeNames = charArrayOf('F', 'G', 'H', 'I', 'J', 'K')

    try {
        val file = File("hasPathDirected.in")
        if (file.exists()) {
            val reader = FileReader(file)
            val buffer = BufferedReader(reader)

            val rows = buffer.readLine().toInt()
            val columns = buffer.readLine().toInt()

            //creating a node array
            val graphNodes = ArrayList<Node>()
            for (i in nodeNames.indices) {
                val node = Node(nodeNames[i], 0)
                graphNodes.add(node)
            }
            for (i in 0 until rows) {
                // creating a list of strings from input file
                val edges = buffer.readLine().split(" ")
                for (j in edges.indices) {
                    if (edges[j].toInt() == 1) {
                        graphNodes[i].addNeighbor(graphNodes[j])
                    }
                }
            }

            println(graphNodes)
            val graph = Graph(graphNodes)
            graph.displayGraph()
            println(
                hasPathProblemUndirectedGraph(graphNodes[2], graphNodes[graphNodes.size - 1])

            )
        } else {
            file.createNewFile()
        }
    } catch (e: IOException) {
        println(e.message)
    }
}

fun hasPathProblemUndirectedGraph(start: Node, destination: Node): Boolean {
    if (start == destination) {
        return true
    }
    for (i in start.neighbors.indices) {
        if (hasPathProblemUndirectedGraph(start.neighbors[i], destination)) {
            return true
        }
    }

    return false

}