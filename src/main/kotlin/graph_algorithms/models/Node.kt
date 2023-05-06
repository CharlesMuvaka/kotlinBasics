package graph_algorithms.models

class Node(val name: Char, val weight: Int) {
    val neighbors = ArrayList<Node>()
    fun addNeighbor(node: Node){
        neighbors.add(node)
    }

    override fun toString(): String {
        return this.name.toString()
    }


}

class Graph(private val graphNodes: ArrayList<Node>){
    fun displayGraph(){
        for (i in graphNodes.indices){
            println("${graphNodes[i].name} : ${graphNodes[i].neighbors}")
        }
    }

}