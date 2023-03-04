package datastructures

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException

/*
 * Given a Set of Edges representing Vision's Neural Network, identify all of the
 * vertices that connect to the Mind Stone.
 * List the names of these neurons in the output file.
 *
 *
 * Steps to implement this class main method:
 *
 * Step 1:
 * MindStoneNeighborNeuronsInputFile name is read using a file reader and a buffered reader
 * Read from the MindStoneNeighborNeuronsInputFile with the format:
 *    1. v (int): number of neurons (vertices in the graph)
 *    2. v lines, each with a String referring to a neuron's name (vertex name)
 *    3. e (int): number of synapses (edges in the graph)
 *    4. e lines, each line refers to an edge, each line has 2 (two) Strings: from to
 *
 * Step 2:
 * Identify the vertices that connect to the Mind Stone vertex.
 * Output these vertices, one per line.
 *
 * Note 1: The Mind Stone vertex has out degree 0 (zero), meaning that there are
 * no edges leaving the vertex.
 *
 * Note 2: If a vertex v connects to the Mind Stone vertex m then the graph has
 * an edge v -> m
 *
 * @author Charles Muvaka
 */

class MindStoneNeighborNeurons {

    init{
        readFromTheFile()
    }
    private fun readFromTheFile(){
        try{
            //initialising files to read data from
            val inputFile = File("mindestoneneighborneurons.in")
            val inputFile1 = File("mindestoneneighborneurons1.in")
            val inputFile2 = File("mindestoneneighborneurons2.in")
            val inputFile3 = File("mindestoneneighborneurons3.in")

            if (inputFile.exists()){
                //initialising a file reader instance to read the file
                val fileReader = FileReader(inputFile)

                //initialising a buffered reader to read the files actual content
                val bufferedReader = BufferedReader(fileReader)


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