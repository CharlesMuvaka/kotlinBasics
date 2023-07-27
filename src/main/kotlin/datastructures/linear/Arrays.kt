package datastructures.linear

/*
                Arrays
 - They are used to store multiple elements of the same data type together.
 - There are several ways of declaring arrays in kotlin.
            1. Use of the arrayOf() function
  - This function creates an array by specifying the elements of it as arguments of the method.
  NOTE: You can explicitly state the data type of the elements of the array as a generic in the function or fail to.
        When you fail to specify the data type of the elements of the array, the compiler will infer the data type from the elements specified.

  - You can also declare an empty array by using the arrayOfNulls function. It takes in an integer as an argument and the integer specifies the size of the array.
  NOTE: Each kotlin primitive data type has a function associated with it on how to create arrays
        - It is usually the name of the primitive followed by the arrayOf function.
        Example:
                val intArray = intArrayOf()
                val byteArray = byteArrayOf()
                val doubleArray = doubleArrayOf()
                Common methods associated with arrays
  1. distinct
    - Checks for elements that are similar in the array and returns a new array without duplicates

    Difference between IntArray and Array<Int>
 */

fun main() {
    //creating a string array using the arrayOf function
    val fruits = arrayOf("Mango", "Banana", "Orange","Apple","Passion", "Peas", "Banana","Banana","Mango", "Peas", "Apples")

    //specifying the data type of the elements involved iin the array
    val studentMarks = arrayOf<Int>(1,2,3,4,5,6,7,8)

    //creating an array of empty elements
    val emptyArray = arrayOfNulls<String>(5)
    emptyArray[4] = "Charles"

    //regenerating the fruits array without duplicate elements
    val distinct = fruits.distinct()

    //
    val customArray = floatArrayOf(5.3f, 4.5f, 6.5f, 7.6f)

    for (i in customArray.indices){
        println(customArray[i])
    }

}