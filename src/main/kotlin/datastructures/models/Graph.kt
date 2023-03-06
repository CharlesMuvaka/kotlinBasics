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

        //adding the starting node to the stack
        stack.add(startNode)

        //looping through the matrix to get the nodes connected to the start node
        for (i in matrix.indices){
            if (i == startNode){
                while (stack.size != 0){
                    val currentNode = stack.pop()
                    //printing the current node to the console
                    println(currentNode)
                    for (j in matrix[currentNode].indices){
                        // checking to see whether the current node has neighbors
                        if (matrix[currentNode][j] == 1){
                            //adding the current node's neighbor to the stack
                            stack.push(j)
                        }
                    }
                }

            }else{
                println("The node entered isn't present in the graph")
            }
        }

    }
}