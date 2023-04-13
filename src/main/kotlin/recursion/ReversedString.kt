package recursion

class ReversedString {
    fun reverseString(input: String): String{
        //base case
        if (input == ""){
            return ""
        }
        return reverseString(input.substring(1)) + input.subSequence(0,1)
    }

    fun isPalindrome(input: String): Boolean{
        //base case
        if (input.isEmpty() || input.length == 1 ){
            return true
        }

        //performing the check recursively.
        if (input.substring(0,1) == input.substring(input.length - 1)){
            return isPalindrome(input.substring(1, input.length -1))
        }
        return false
    }
}


fun main() {
    println(ReversedString().reverseString("You are good"))
    println(ReversedString().isPalindrome("eye"))
}