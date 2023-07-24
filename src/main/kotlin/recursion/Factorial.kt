package recursion

fun main() {
    println(factorial(10))
}

fun factorial(num: Int): Int{
    if (num == 1){
        return 1
    }
    return num * factorial(num -1)
}