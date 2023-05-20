package graph_algorithms

import graph_algorithms.models.Graph
import graph_algorithms.models.Node
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException

fun main() {
    val file = File("largestComponent.in")
    val graphNames = arrayOf('0','1', '2', '3', '4', '5', '8')
    val graphNodes = ArrayList<Node>()
    val graph = Graph(graphNodes)

    try{
        if (file.exists()){
            val reader = FileReader(file)
            val buffer = BufferedReader(reader)

            val components = buffer.readLine().toInt()

            //creating the graph components
            for (i in 0 until components){
                val node = Node(graphNames[i], 0)
                graphNodes.add(node)
            }

            //adding neighbors to the nodes
            for (i in graphNodes.indices){
                //creating a list of strings from the edges
                val edges = buffer.readLine().split(" ")
                for (j in edges.indices){
                    //converting the string into an integer
                    val edge = edges[j].toInt()
                    //checking there is a relationship with the current node
                    if (edge == 1){
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