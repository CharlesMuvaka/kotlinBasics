package graph_algorithms

import graph_algorithms.models.Graph
import graph_algorithms.models.Node
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException

/*
                                UnDirected graphs
   - These type of graphs the direction of the edges is not indicated
                i ---- j, meaning its bidirectional.
   - While traversing through these graphs, we might get trapped in infinite loops. Imagine
                    i
                   / \
                  j---k, Below is the graph visually.
     - val graph = arrayListOf(
        i : [j, k],
        j : [i, k],
        k : [i, j]
     )
     - When our start node in the traversal is i, we consider its neighbors, j and k and add them to the
        stack, we pop out the last node which will be k in our case and then consider its neighbors, i and j
        and add them in the stack, we pop out the last node which is j and consider its neighbors, i and k
        and add them in the stack. When we pop out our last node, it will be k which we had already traversed through.

        - To counter this problem, we have to create a bag to monitor out traversed nodes. This bag will help us in
          terminating the infinite loop.
 */

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