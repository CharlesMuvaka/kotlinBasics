package graph_algorithms

import graph_algorithms.models.Graph
import graph_algorithms.models.Node
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException

fun main() {
    val nodeNames = charArrayOf('1','2','3','4','5','6','7','8','9')
    val graphNodes = ArrayList<Node>()
    val graph = Graph(graphNodes)

    try{
        val file = File("connectedComponents.in")
        if (file.exists()){
            val reader = FileReader(file)
            val buffer = BufferedReader(reader)

            val components = buffer.readLine().toInt()

            //creating the graph nodes
            for (i in 0 until components){
                val node = Node(nodeNames[i], 0)
                graphNodes.add(node)
            }

            //adding the node neighbors
            for(i in graphNodes.indices){
                //creating a list of strings from the input file
                val edges = buffer.readLine().split(" ")

                for (j in edges.indices){
                    val edge = edges[j].toInt()
                    if (edge == 1){
                        graphNodes[i].addNeighbor(graphNodes[j])
                    }
                }
            }

            //displaying the graph nodes
            graph.displayGraph()

            //initialising the set to store visited nodes
            val visited = HashSet<Node>()

            val count = connectedComponents(graphNodes, visited)

            println("------Printing the number of components")
            println(count)
        }else{
            file.createNewFile()
        }
    }catch (e: IOException){
        println(e.message)
    }
}

fun connectedComponents(graphNodes: ArrayList<Node>, visited: HashSet<Node>): Int{
    //initialising the counter
    var counter = 0

    for (i in graphNodes.indices){
        if (exploreNeighbors(graphNodes[i], visited)){
            counter++
        }
    }
    return counter
}

fun exploreNeighbors(node: Node, visited: HashSet<Node>): Boolean {
    if (visited.contains(node)){
        return false;
    }
    //adding the current node in the set
    visited.add(node)

    for (i in node.neighbors.indices){
        //performing the traversal recursively
        exploreNeighbors(node.neighbors[i], visited)
    }

    return true

}
