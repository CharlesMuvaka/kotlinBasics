package graph_algorithms

import graph_algorithms.models.Graph
import graph_algorithms.models.Node
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException

fun main(){
    //defining node names
    val nodeNames = charArrayOf('i', 'j', 'k', 'l', 'm', 'n', 'o')
    try{
        val file = File("hasPathUnDirected.in")
        if (file.exists()){
            val reader = FileReader(file)
            val buffer = BufferedReader(reader)

            val rows = buffer.readLine().toInt()

            //initialising an arrayList to store the graph nodes
            val adjacencyList = ArrayList<Node>()

            //creating the graph nodes
            for (i in 0 until rows){
                val node = Node(nodeNames[i], 0)
                adjacencyList.add(node)
            }

            for (i in 0 until rows){
                //reading the graph edges from the input file
                val stringEdges = buffer.readLine()

                //creating a list of strings from the string edges
                val edges = stringEdges.split(" ")

                //adding neighbors to the graph nodes based on the matrix
                for (j in edges.indices){
                    val edge = edges[j].toInt()
                    if (edge == 1){
                        adjacencyList[i].addNeighbor(adjacencyList[j])
                    }
                }
            }

            //initialising an instance of the graph
            val graph = Graph(adjacencyList)

            //displaying the contents of the graph
            graph.displayGraph()

        }else{
            file.createNewFile()
        }
    }catch(e :IOException){
        println(e.message)
    }
}