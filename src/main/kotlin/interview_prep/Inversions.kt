package interview_prep


/*
                                                Inversions
    - An array inversions tends to check if the array has been sorted.
    - To know the number of inversions present in an array, we check if the first elements of the array are greater than the preceeding elements in the array.
    - Example:
            Given an array val array = intArrayOf(1,2,3,4,5,6), we can clearly say that there are no inversions in the array since it has been sorted.
            Given an array val array = intArrayOf(6,5,4,3,2,1) we can say that the array contains the listed inversions - 15 inversions.
                    (6,5)   (5,4)   (4,3)   (3,2)   (2,1)
                    (6,4)   (5,3)   (4,2)   (3,1)
                    (6,3)   (5,2)   (4,1)
                    (6,2)   (5,1)
                    (6,1)
    - Tio calculate the number of inversions present in an array we.
        1. Declare a variable to store the inversions count.
        2. Loop over the elements iof the array  ignoring the last element and initialise a current element in each iteration.
        3. Create an inner loop ignoring the first element and create the next element.
        4. Compare the current element to the next element.
        5. If the current element is greater than the next then increase the inversion count.
 */

fun main() {
    val array = intArrayOf(6,5,4,3,2,1)
    val array1 = intArrayOf(1,2,3,4,5,6)
    val num = arrayInversion(array)
    println(num)
}

fun arrayInversion(array: IntArray): Int {
    ///initialising a variable to count the inversions
    var inversionCount = 0

    // looping over the elements in  the array
    for (i in 0 until array.size - 1){
        //initialising the current variable
        val current = array[i]

        //creating an inner loop
        for (j in i + 1 until array.size){
            val next = array[j]
            //comparing the array elements
            if(current > next){
                //increasing the inversion count
                inversionCount++
                println("($current, $next)")
            }
        }
    }
    return inversionCount
}
