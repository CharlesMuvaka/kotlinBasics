package interview_prep

/*
                        Right Rotation
     - Given an array of size N, rotate its elements to the right in d positions
        Example: val array = intArrayOf(1,2,3,4,5,6,7,8)
                 val d = 2;

       Process.
       1. Create a temporary array to hold the rotated elements
       2. Define an integer variable to track the current position.
       3. Check to see if the rotation steps are greater than the array size.

       NOTE: The last d elements of the original array will be the first elements in the temporary array.
 */

fun main() {
    val size = intArrayOf(121, 232, 33, 43 ,5)
    val d = 2;
    rightRotation(size, d)


}

fun rightRotation(array: IntArray, d: Int){
    //creating a temporary array to hold the rotated elements
    val temp = IntArray(array.size)

    //declaring a variable to track our current progress
    var counter = 0;

    //checking is the steps is larger than the array size
    var steps = d
    if(steps > array.size){
        steps %= array.size
    }

    var limit = array.size - steps

    //adding the last d elements of the original array to the temporary array
    for(i in limit until array.size){
        temp[counter] = array[i]
        counter++
    }

    //adding the first element to the dth element in the temp array
    for(i in 0 until limit){
        temp[counter] = array[i]
        counter++
    }

    //printing the elements in the temp array
    for(i in 0 until temp.size){
        print("${temp[i]} ")
    }


}