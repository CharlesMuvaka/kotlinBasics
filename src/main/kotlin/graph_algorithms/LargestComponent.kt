package graph_algorithms

/*
                                    Largest component
  - Aims to check the component with the most number of nodes
    Process
   1. We first traverse through the nodes
   2. We count the neighbors of that node.
   3. The node with the largest number of neighbors has to be the largest component.

        NOTE: We have to mark nodes as visited to avoid cycles.

 */

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
            //printing the largest component
            println("------------Printing the largest component--------")
            depthFirst(graphNodes)


        }else{
            file.createNewFile()
        }
    }catch (e: IOException){
        println(e.message)
    }

}


//defining a method to traverse though the nodes
private fun depthFirst(graphNodes: ArrayList<Node>){
    //initialising a variable to store the visited nodes
    val visited = HashSet<Node>()

    //initialising a variable to store the largest component
    var largest = 0

    //traversing through the neighbors of the node
    for (i in  graphNodes.indices){
        //getting the number of neighbors
        val size = exploreNeighbor(graphNodes[i], visited)
        if (size > largest) largest = size
    }

    println(largest)
}