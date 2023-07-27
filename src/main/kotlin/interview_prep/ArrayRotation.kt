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
    val d = 4
    val nums = leftRotation(numbers, d)

    for (i in nums.indices){
        //print(nums[i])
    }

    //print(fibonacci(10))
    //print(isPalindrome("eyee"))
    print(splitString("I yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyym a good bo00000000y"))

}

fun leftRotation(numbers: Array<Int>, steps:Int): IntArray {
    //initialising a temporary array
    val nums = IntArray(numbers.size)

    // define a variable to check wether the rotation steps is greater that the array size
    var d = steps;

    if (d > numbers.size){
        d -= numbers.size
    }

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
//function that returns the fibonacci number
fun fibonacci(number: Int): Int{
    if(number == 0 || number == 1){
        return number
    }
    return fibonacci(number -1) + fibonacci(number -2)
}

//function that checks whether a given number is a palindrome
fun isPalindrome(word: String): Boolean{
    if (word.length == 0 || word.length == 1){
        return true
    }

    if (word.substring(0,1) == word.substring(word.length -1)){
        return isPalindrome(word.substring(1, word.length -1))
    }
    return false
}

//function that splits a string a returns the longest string
fun splitString(sentence: String): String{
    var result = ""
    if(!sentence.contains(" ")){
        result = sentence
    }
    val splitSentence = sentence.split(" ")
    var counter = 0

    for (i in 1 until splitSentence.size){
        var string1 = ""
        var string2 = ""
        for (j in 0 until splitSentence[i].length ){
            if (splitSentence[i][j].isLetterOrDigit()){
                string1 += splitSentence[i][j]
            }
        }
        for (j in 0 until splitSentence[counter].length ){
            if (splitSentence[counter][j].isLetterOrDigit()){
                string2 += splitSentence[counter][j]
            }
        }
        result = string2
        println(string1)

        if (result.length < string1.length){
            result = string2
        }

        if (result.length == string1.length){
            result = result
        }
        counter++
    }
    return result
}