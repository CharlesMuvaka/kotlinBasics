package datastructures.linear

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException

fun main(){
    val file = File("repetitive.in")
    try {
        if (file.exists()){
            val reader = FileReader(file)
            val buffer = BufferedReader(reader)
            val arraySize = buffer.readLine().toInt()
            val array = buffer.readLine().split(" ")
            val keys = array.distinct()

            //initialising a map to store the e,lememnts
            val map = HashMap<Int, ArrayList<Int>>()

            for (i in 0 until keys.size){
                val list = ArrayList<Int>()

                for(j in 0 until arraySize){
                   if(keys[i].toInt() == array[j].toInt()){
                       list.add(array[j].toInt())
                   }
                }
                map[keys[i].toInt()] = list
            }
            //initialising a ist to store the more elements in the array
            var many = ArrayList<Int>()

            for (i in 0 until map.size - 1){
                for (j in i + 1  until map.size){
                    if (map[keys[i].toInt()]!!.size > map[keys[j].toInt()]!!.size ){
                        many = map[keys[i].toInt()]!!
                    }else{
                        many = map[keys[j].toInt()]!!

                    }
                }
            }
            println(many)

        }else{
            file.createNewFile()
        }
    }catch (e: IOException){
        println(e.message)
    }
}