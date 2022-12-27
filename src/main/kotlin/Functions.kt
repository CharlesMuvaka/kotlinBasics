fun main() {
//    println(addNumbers(10,20))
//    println(20.addNumbers())
//    println(20.addNumber(20))

    val intArray = displayFinobaciNumbers(0,5)
    for (number in intArray){
        println(number)
    }
}
//Declaring helper functions
fun addNumbers(number: Int, numberTwo: Int ): Int{
    return number + numberTwo
}

//Declaring extensive functions
fun Int.addNumbers(): Int {
    return this + 10
}//Declaring extensive functions
fun Int.addNumber(number: Int): Int {
    return this + number
}

fun displayFinobaciNumbers(start:Int, end:Int): HashSet<Int>{

    val finobaciNumbers = HashSet<Int>()
    finobaciNumbers.add(start)
    for (i in start..end){
        var numberIterator: Iterator<Int> = finobaciNumbers.iterator()
        println(numberIterator.toString())
//        var secondNumber =  finobaciNumbers.
    }
    return finobaciNumbers
}