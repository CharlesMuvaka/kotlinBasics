package recursion

class ReversedString {
    fun reverseString(input: String): String{
        //base case
        if (input == ""){
            return ""
        }
        return reverseString(input.substring(1)) + input.subSequence(0,1)
    }
}



fun main() {
    println(ReversedString().reverseString("You are good"))
}