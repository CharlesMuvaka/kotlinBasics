package datastructures

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

/*
  * Given an adjacency matrix, use a random() function to remove half of the nodes.
 * Then, write into the output file a boolean (true or false) indicating if
 * the graph is still connected.
 *
 * Steps to implement this class main method:
 *
 * Step 1:
 * PredictThanosSnapInputFile is read using an file reader and a buffered reader
 * Read from PredictThanosSnapInputFile with the format:
 *    1. seed (long): a seed for the random number generator
 *    2. p (int): number of people (vertices in the graph)
 *    2. p lines, each with p edges: 1 means there is a direct edge between two vertices, 0 no edge
 *
 * Note: the last p lines of the PredictThanosSnapInputFile is an ajacency matrix for
 * an undirected graph.
 *
 * The matrix below has two edges 0-1, 0-2 (each edge appear twice in the matrix, 0-1, 1-0, 0-2, 2-0).
 *
 * 0 1 1 0
 * 1 0 0 0
 * 1 0 0 0
 * 0 0 0 0
 *
 * Step 2:
 * Delete random vertices from the graph. You can use the following pseudocode.
 * StdRandom.setSeed(seed);
 * for (all vertices, go from vertex 0 to the final vertex) {
 *     if (StdRandom.uniform() <= 0.5) {
 *          delete vertex;
 *     }
 * }
 * Answer the following question: is the graph (after deleting random vertices) connected?
 * Output true (connected graph), false (unconnected graph) to the output file.
 *
 * Note 1: a connected graph is a graph where there is a path between EVERY vertex on the graph.
 *
 *   To write to a file use a file writer (here, isConnected is true if the graph is connected,
 *   false otherwise):
 *     StdOut.setFile(outputfilename);
 *     StdOut.print(isConnected);
 *
 * @author Charles Muvaka
 */

class PredictThanosSnap {
    fun readFromTheInPutFile(){
        val inputFile = File("predictthanossnap.in")
        val inputFile1 = File("predictthanossnap1.in")
        val inputFile2 = File("predictthanossnap2.in")
        val inputFile3 = File("predictthanossnap3.in")

        //initialising a file reader to read the byte contents of the file
        val fileReader = FileReader(inputFile)

        //initialising a buffered reader to read the actual contents of the file
        val bufferedReader = BufferedReader(fileReader)

        if (inputFile.exists()){
            //reading the seed for the random number generator from the input file
            val seed = bufferedReader.readLine().toInt()

            //reading the number of people (vertices in the graph)
            val vertices = bufferedReader.readLine().toInt()

            //initialising a matrix to store the graph edges
            val matrix = Array(vertices){IntArray(vertices)}

            //reading the graph edges from the file
            for (i in 0 until vertices){
                val edges = bufferedReader.readLine().split(" ")
                for (j in edges.indices){
                    matrix[i][j] = edges[j].toInt()
                }
            }

        }else{
            inputFile.createNewFile()
            inputFile1.createNewFile()
            inputFile2.createNewFile()
            inputFile3.createNewFile()
        }

    }
}