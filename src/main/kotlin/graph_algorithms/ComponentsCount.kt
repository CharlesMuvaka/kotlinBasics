package graph_algorithms

import graph_algorithms.models.Graph
import graph_algorithms.models.Node
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException

fun main() {
    val file = File("componentsCount.in")
    val graphNodes = arrayListOf<Node>()
    val graph = Graph(graphNodes)
    val componentsNames = charArrayOf('1','2','3','4','5','6','7','8')

    try {
        if (file.exists()){
            val reader = FileReader(file)
            val buffer = BufferedReader(reader)

            val components = buffer.readLine().toInt()
            for (i in 0 until components){
                val node = Node(componentsNames[i], 0)
                graphNodes.add(node)
            }

            //adding neighbors to the nodes from the input file
            for (i in 0 until components){
                //creating a list of strings
                val edges = buffer.readLine().split(" ")
                for (j in edges.indices){
                    if (edges[j].toInt() == 1){
                        graphNodes[i].addNeighbor(graphNodes[j])
                    }
                }
            }

            graph.displayGraph()

        }else{
            file.createNewFile()
        }
    }catch (e: IOException){
        println(e.message)
    }
}