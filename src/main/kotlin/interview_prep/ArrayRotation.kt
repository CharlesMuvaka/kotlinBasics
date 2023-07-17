package interview_prep
/*
                                    Array Rotation
 - Given an array of integers of size N. Rotate the elements to the left by d positions.
 Examole:
            val numbers = arrayOf(1,2,3,4,5,6,7)
            val d = 2

 NOTE: After rotating d positions to the left, the first d elements become the last d elements of the array.
 From the above example, the output of the result would be.
  val numbers = {3,4,5,6,7,1,2}

  Approaches.
  1. Using a temporary array.
   - Create a temporary array
   - Store elements from d to n-1 of the original array to the temporary array
   - Store the first element to element d-1 of the original array in the temporary array.
   - Copy all the elements of the temporary array to the original array
 */
fun main() {
    val numbers = arrayOf(1,2,3,4,5,6,7)
    val d = 2
    val nums = leftRotation(numbers, d)

    for (i in nums.indices){
        print(nums[i])
    }

}

fun leftRotation(numbers: Array<Int>, d: Int): IntArray {
    //initialising a temporary array
    val nums = IntArray(numbers.size)

    //initialising an integer to mark our current position in the temporary array
    var counter = 0

    // storing element d to element n-1 of the original array in the temporary array
    for(i in d until numbers.size){
        val number = numbers[i]
        nums[counter] = number
        counter++
    }

    //storing element 0 to element d-1 of the original array in the temporary array
    for(i in 0 until d){
        val number = numbers[i]
        nums[counter] = number
        counter++
    }
    return nums
}
