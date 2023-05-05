package graph_algorithms

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException
import java.util.PriorityQueue

/*
    Breadth first traversal involves checking all the neighbors of the current node being traversed before
        moving to the next node.
    It uses a queue to perform its operations.
        A queue uses the First in First Out architecture.
        An example using an adjacent list:
            val nodes = [
                0 : [1, 2],
                1 : [3],
                2 : [4],
                3 : [5],
                4 : [],
                5 : []
            ]

            if the traversal began at the 0 node, we have to add all its neighbors(1,2) to the queue.
            When removing a node from the queue, it will return 1 since it was the one that entered first
                            TRAVERSAL PROCESS
            1. Initialise a queue to store the nodes.
            2. Add the starting node in the queue
            3. Create a breaking condition of the method. While the queue is not empty. Remember its size now is 1
            4. Removing the node in the queue and make it your current node.
            5. Add its neighbors in the queue.

            NOTE: the remove method gives you the first item that entered the queue and it removes it from the queue
                - The while loop will make the program terminate when the queue has removed all its elements.
                - You cannot perform a breadth first traversal recursively since it uses a queue and recursion uses stacks
                 to call out its iterations.
 */

fun main() {
    try{
        val file = File("depthFirstTraversal.in")
        if (file.exists()){
            val reader = FileReader(file)
            val buffer = BufferedReader(reader)

            val rows = buffer.readLine().toInt()
            val columns = buffer.readLine().toInt()

            // initialising a 2D array
            val matrix = Array(rows){ IntArray(columns)}

            //populating the edges of the matrix from the file
            for (i in 0 until rows){
                // creating a list of the edges in string formats
                val edges = buffer.readLine().split(" ")
                for (j in edges.indices){
                    matrix[i][j] = edges[j].toInt()
                    print(matrix[i][j])
                }
                println()
            }

            breadthFirstTraversal(matrix[0][0], matrix)

        }else{
            file.createNewFile()
        }
    }catch (e: IOException){
        println(e.message)
    }
}

fun breadthFirstTraversal(start: Int, matrix: Array<IntArray> ){
    //initialising a queue to store the nodes being traversed
    val nodes = PriorityQueue<Int>()

    //adding the start node to the queue
    nodes.add(start)

    // creating a condition to terminate the program
    while (!nodes.isEmpty()){
        //getting the node being traversed through
        val current = nodes.remove()
        print("$current ---> ")

        //adding the neighbors of the current node being traversed
        for (i in matrix[current].indices){
            if (matrix[current][i] == 1){
                nodes.add(i)
            }
        }
    }
}