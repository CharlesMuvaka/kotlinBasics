package datastructures

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.Reader
import java.util.LinkedList

///*
// *
// * Given the 2D array where the values are the flux intensity data of the
// * Neutron Star, calculate the total flux that Thor has to endure.
// *
// * Steps to implement this class main method:
// *
// * Step 1:
// * ForgeStormbreakerInputFile name is passed through the command line as args[0]
// * Read from the ForgeStormbreakerInputFile with the format:
// *    1. r (int): number of rows
// *    2. c (int): number of columns
// *    3. r lines, each with c values
// *  Create and populate a 2D array with r rows and c columns with ForgeStormbreakerInputFile
// *  data.
// *
// * Step 2:
// * ForgeStormbreakerOutputFile name is passed through the command line as args[1]
// * Given the 2D array where the values are the flux intensity data of the
// * Neutron Star, calculate the total flux that Thor has to endure by summing
// * all values of the 2D array.
// * Output this number into the output file.
// *
// * Note 1: the contents of the 2D array are guaranteed to be integers!
// * Note 2: use the StdIn/StdOut libraries to read/write from/to file.
//
// * @author Charles Muvaka
// */

class ForgeStormBreaker {
    init {
        try {
            val file = File("forgestormbreaker.txt")
            val file1 = File("forgestormbreaker1.txt")
            val file2 = File("forgestormbreaker2.txt")
            val file3 = File("forgestormbreaker3.txt")

            if (file3.exists()){
                //initialising a file reader to reade the byte contents of the file
                val fileReader = FileReader(file1)

                // initialising a buffered reader to read the actual content from the reader
                val bufferedReader = BufferedReader(fileReader)

                // getting the number of rows of the 2D array
                val rows = bufferedReader.readLine().toInt()

                // getting the columns of the 2D array
                val columns = bufferedReader.readLine().toInt()

                //defining a queue to store the flux intensity
                val fluxIntensityQueue = LinkedList<Int>()

                //reading the remaining lines to get the flux intensity of the neuron star
                for(i in 0 until  rows){
                    var fluxIntensityString = bufferedReader.readLine().split(" ")
                    for (j in fluxIntensityString.indices){
                        if (fluxIntensityString[j].isNotBlank()){
                            fluxIntensityQueue.add(fluxIntensityString[j].toInt())

                        }
                    }

                }

                //initialising a 2D array
                val matrix = Array(rows) { IntArray(columns) }

                //define a variable to store the flux intensity sum
                var sum = 0;
                for (i in 0 until rows){
                    for (j in 0 until  columns){
                        matrix[i][j] = fluxIntensityQueue.remove()
                        print("${matrix[i][j]} ")
                        sum += matrix[i][j]
                    }
                    println(" ")
                }

                println("Graph's total flux intensity: $sum")

            }else{
                file.createNewFile()
                file1.createNewFile()
                file2.createNewFile()
                file3.createNewFile()
            }
        }catch (e:Exception){
            println(e.message)
        }
    }
}

fun main() {
    val forgeStormBreaker = ForgeStormBreaker()
}