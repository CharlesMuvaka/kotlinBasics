package datastructures

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.util.LinkedList
import javax.annotation.processing.FilerException


///**
// *
// * Using the Adjacency Matrix of n vertices and starting from Earth (vertex 0),
// * modify the edge weights using the functionality values of the vertices that each edge
// * connects, and then determine the minimum cost to reach Titan (vertex n-1) from Earth (vertex 0).
// *
// * Steps to implement this class main method:
// *
// * Step 1:
// * LocateTitanInputFile name is read using a file reader and a buffered reader
// * Read from LocateTitanInputFile with the format:
// *    1. g (int): number of generators (vertices in the graph)
// *    2. g lines, each with 2 values, (int) generator number, (double) funcionality value
// *    3. g lines, each with g (int) edge values, referring to the energy cost to travel from
// *       one generator to another
// * Create an adjacency matrix for g generators.
// *
// * Populate the adjacency matrix with edge values (the energy cost to travel from one
// * generator to another).
// *
// * Step 2:
// * Update the adjacency matrix to change EVERY edge weight (energy cost) by DIVIDING it
// * by the functionality of BOTH vertices (generators) that the edge points to. Then,
// * typecast this number to an integer (this is done to avoid precision errors). The result
// * is an adjacency matrix representing the TOTAL COSTS to travel from one generator to another.
// *
// * Step 3:
// * LocateTitanOutputFile name is passed through the command line as args[1]
// * Use Dijkstra’s Algorithm to find the path of minimum cost between Earth and Titan.
// * Output this number into your output file!
// *
// * @author Charles Muvaka
// *
//**/
//

class LocateTitan {

    init {
        try {
            val inputFile = File("LocateTitanInputFile.in")
            val inputFile1 = File("LocateTitanInputFile1.in")
            val inputFile2 = File("LocateTitanInputFile2.in")
            val inputFile3 = File("LocateTitanInputFile3.in")

            if (inputFile.exists()){

                //initialising a file reader to read the file byte content
                val fileReader = FileReader(inputFile)

                //initialising a buffered reader to read the files actual content
                val bufferedReader = BufferedReader(fileReader)

                //reading the number of generators in the graph
                val generators = bufferedReader.readLine().toInt()

                //initialize a map to store a generator and its functionality value
                val functionalityValueMap = HashMap<Int, Double>()

                for (i in 0 until generators){
                    var generatorAndValue = bufferedReader.readLine().split(" ")
                    functionalityValueMap[generatorAndValue[0].toInt()] = generatorAndValue[1].toDouble()
                }

                //initialising a matrix to store the graphs data
                val matrix = Array(generators){IntArray(generators)}

                //initialising a queue to store the graph edges
                val edgeQueue = LinkedList<Int>()

                for (i in 0 until generators){
                    var graphEdges = bufferedReader.readLine().split(" ")
                    for (j in graphEdges.indices){
                        if (graphEdges[j].isNotBlank()){
                            edgeQueue.add(graphEdges[j].toInt())
                        }
                    }
                }

                for (i in 0 until generators){
                    val cost = functionalityValueMap[i]
                    for (j in 0 until generators){
                        val cost1 = functionalityValueMap[j]
                        matrix[i][j] = edgeQueue.remove()
                        if (cost != null) {
                            // defining the edge based on the total cost of the vertices
                            matrix[i][j] = (matrix[i][j]/ (cost * cost1!!)).toInt()
                        }
                        print("${matrix[i][j]} ")
                    }
                    println(" ")
                }

            }else{
                inputFile.createNewFile()
                inputFile1.createNewFile()
                inputFile2.createNewFile()
                inputFile3.createNewFile()
            }
        }catch (e: FilerException){
            println(e.message)
        }
    }
}

fun main() {
    val forgeStormBreaker = LocateTitan()
}