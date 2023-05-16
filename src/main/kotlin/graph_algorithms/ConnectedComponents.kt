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
        }else{
            file.createNewFile()
        }
    }catch (e: IOException){
        println(e.message)
    }
}