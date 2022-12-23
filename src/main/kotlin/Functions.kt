fun main() {
    println(addNumbers(10,20))
    println(20.addNumbers())
}
//Declaring helper functions
fun addNumbers(number: Int, numberTwo: Int ): Int{
    return number + numberTwo
}

//Declaring extensive functions
fun Int.addNumbers(): Int {
    return this + 10
}