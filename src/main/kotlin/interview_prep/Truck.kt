package interview_prep

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException

/*
                     Problem
        Arpasland has surrounded by attackers. A truck enters the city. The driver claims the load is food and medicine from Iranians.
        Ali is one of the soldiers in Arpasland. He doubts about the truck, maybe it's from the siege. He knows that a tag is valid if the sum of every two consecutive digits of it is even and its letter is not a vowel.
         Determine if the tag of the truck is valid or not.
        We consider the letters "A","E","I","O","U","Y" to be vowels for this problem.

                    Input Format
The first line contains a string of length 9. The format is "DDXDDD-DD", where D stands for a digit (non zero) and X is an uppercase english letter.

                    Output Format
Print "valid" (without quotes) if the tag is valid, print "invalid" otherwise (without quotes)
 */

fun main() {
    val file = File("truck.in")
    readFromInputFile(file)
}

fun readFromInputFile(file: File){
    val vowels = arrayOf("A","E","I","O","U","Y")
    val numbers = ArrayList<Int>()
    val nonNumbers = ArrayList<String>()
    var summation = 0;
    if (file.exists()){
        try {
            val reader = FileReader(file);
            val buffer = BufferedReader(reader);

            val plate = buffer.readLine()
            for (i in plate.indices){
                if (plate[i].isDigit()){
                    numbers.add(plate[i].digitToInt())
                }else if(plate[i].isLetter()){
                    nonNumbers.add(plate[i].toString())
                }
            }

            for (i in 1 until numbers.size){
                val sum = numbers[i] + numbers[i-1]
                summation += sum
            }
           if (vowels.contains(nonNumbers[0]) && (summation % 2 != 0)){
               println("INVALID")
           }else{
               println("VALID")
           }

        }catch (e: IOException){
            println(e.message)
        }
    }else{
        file.createNewFile()
    }
}