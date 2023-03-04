package datastructures

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException

/*
 * Given a starting event and an Adjacency Matrix representing a graph of all possible
 * events once Thanos arrives on Titan, determine the total possible number of timelines
 * that could occur AND the number of timelines with a total Expected Utility (EU) at
 * least the threshold value.
 *
 *
 * Steps to implement this class main method:
 *
 * Step 1:
 * timeStone file name is read using the file reader and a buffered reader
 * Read from timeStone file with the format:
 *    1. t (int): expected utility (EU) threshold
 *    2. v (int): number of events (vertices in the graph)
 *    3. v lines, each with 2 values: (int) event number and (int) EU value
 *    4. v lines, each with v (int) edges: 1 means there is a direct edge between two vertices, 0 no edge
 *
 * Note 1: the last v lines of the UseTimeStoneInputFile is an ajacency matrix for a directed
 * graph.
 * The rows represent the "from" vertex and the columns represent the "to" vertex.
 *
 * The matrix below has only two edges: (1) from vertex 1 to vertex 3 and, (2) from vertex 2 to vertex 0
 * 0 0 0 0
 * 0 0 0 1
 * 1 0 0 0
 * 0 0 0 0
 *
 * Step 2:
 * UseTimeStoneOutputFile name is passed through the command line as args[1]
 * Assume the starting event is vertex 0 (zero)
 * Compute all the possible timelines, output this number to the output file.
 * Compute all the posssible timelines with Expected Utility higher than the EU threshold,
 * output this number to the output file.
 *
 * Note 2: output these number the in above order, one per line.
 *
 * @author Charles Muvaka
 *
 */

class UseTimeStone {

    init {
        readFromTheFile()
    }
    private fun readFromTheFile(){
        try {
            //creating the input files to read from
            val inputFile = File("usetimestone.in")
            val inputFile1 = File("usetimestone1.in")
            val inputFile2 = File("usetimestone2.in")
            val inputFile3 = File("usetimestone3.in")

            if (inputFile.exists()){
                val fileReader = FileReader(inputFile)
                val bufferedReader = BufferedReader(fileReader)

                //reading the expected utility (EU) threshold
                val expectedEU = bufferedReader.readLine().toInt()

                //reading the number of events (vertices in the graph)
                val vertices = bufferedReader.readLine().toInt()

                //initialising a map to store the vertices with the threshold
                val verticesAndEu = HashMap<Int, Int>()

                //reading vertex and its expected eu from the file
                for (i in 0 until vertices){
                    //creating an array string containing the vertex and its eu
                    val vertexAndEu = bufferedReader.readLine().split(" ")

                    //storing the vertex and its eu in the map
                    verticesAndEu[vertexAndEu[0].toInt()] = vertexAndEu[1].toInt()
                }

                //initialising a matrix to represent the graph data
                val matrix = Array(vertices){IntArray(vertices)}

                //reading the graph edges from the file
                for (i in 0 until vertices){
                    //creating a string array of the graph edges
                    val edges = bufferedReader.readLine().split(" ")
                }




            }else{
                inputFile.createNewFile()
                inputFile1.createNewFile()
                inputFile2.createNewFile()
                inputFile3.createNewFile()
            }
        }catch (e: IOException){
            println(e.message)
        }
    }
}

fun main() {
    val timeStone = UseTimeStone()
}