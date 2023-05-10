package graph_algorithms

import graph_algorithms.models.*
import java.io.*
import java.util.*
import kotlin.collections.*

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

fun main() {
    //defining node names
    val nodeNames = charArrayOf('i', 'j', 'k', 'l', 'm', 'n', 'o')
    try {
        val file = File("hasPathUnDirected.in")
        if (file.exists()) {
            val reader = FileReader(file)
            val buffer = BufferedReader(reader)

            val rows = buffer.readLine().toInt()

            //initialising an arrayList to store the graph nodes
            val adjacencyList = ArrayList<Node>()

            //creating the graph nodes
            for (i in 0 until rows) {
                val node = Node(nodeNames[i], 0)
                adjacencyList.add(node)
            }

            for (i in 0 until rows) {
                //reading the graph edges from the input file
                val stringEdges = buffer.readLine()

                //creating a list of strings from the string edges
                val edges = stringEdges.split(" ")

                //adding neighbors to the graph nodes based on the matrix
                for (j in edges.indices) {
                    val edge = edges[j].toInt()
                    if (edge == 1) {
                        adjacencyList[i].addNeighbor(adjacencyList[j])
                    }
                }
            }

            //initialising an instance of the graph
            val graph = Graph(adjacencyList)

            //displaying the contents of the graph
            graph.displayGraph()

            // initialising a set to monitor the visited nodes
            val set = HashSet<Node>()

            val start = adjacencyList[0]
            val destination = adjacencyList[4]

            val result = recursiveHasProblemUndirected(start,destination , set)
            //printing out the result
            println("is there a path from $start to $destination: ")
            println(result)
            println()
            println("---------------Breadth First Traversal----------------")
            //breadthFirstHasProblem(start, destination, set)
            //depthFirstHasProblem(start, destination, set)

        } else {
            file.createNewFile()
        }
    } catch (e: IOException) {
        println(e.message)
    }

}

fun recursiveHasProblemUndirected(start: Node, destination: Node, set: HashSet<Node>): Boolean {

    //checking if the current node being traversed is in the set
    if (set.contains(start)) {
        return false
    }

    //adding the current node in the set
    set.add(start)

    print("$start ---> ")

    //confirming if there exists a path between the start and the destination
    if (start == destination) {
        return true
    }

    //traversing through the neighbors
    for (i in start.neighbors.indices) {
        if (recursiveHasProblemUndirected(start.neighbors[i], destination, set)) {
            return true
        }
    }

    //when all the above conditions not met, there is no path
    return false
}

fun breadthFirstHasProblem(start: Node, destination: Node, visited: HashSet<Node>){
    //initialising a queue to hold the nodes being traversed
    val graphNodes = PriorityQueue<Node>()

    //adding the start node in the queue
    val node: Node = start
    graphNodes.add(node)

    //performing the traversal
    while (!graphNodes.isEmpty()){
        val current = graphNodes.remove()
        print(current)
        for (i in  current.neighbors.indices){
            //adding the neighbors in the queue
            graphNodes.add(current.neighbors[i])
        }
    }
}

fun depthFirstHasProblem(start: Node, destination: Node, visited: HashSet<Node>): Boolean{
    //initialising a stack to store the nodes being traversed
    val stack = Stack<Node>()

    //adding the start node in the stack
    stack.add(start)

    //traversing through the nodes
    while(!stack.isEmpty()){
        val current = stack.pop()
        println(current)

        if (visited.contains(current)){
            return false
        }

        if (current.equals(destination)){
            return true
        }

        for (i in current.neighbors.indices){
            val neighbor = current.neighbors[i]
            stack.push(neighbor)
        }
    }

    return false
}