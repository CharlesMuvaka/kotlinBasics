fun main() {
//    println(addNumbers(10,20))
//    println(20.addNumbers())
//    println(20.addNumber(20))

    val intArray = displayFinobaciNumbers(100)
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

fun displayFinobaciNumbers(end:Int): ArrayList<Int>{
    val finobaciNumbers = ArrayList<Int>()
    finobaciNumbers.add(0)
    finobaciNumbers.add(1)
    for (i in 0 .. end){
        var number = finobaciNumbers[i] + finobaciNumbers[i + 1]
        finobaciNumbers.add(number)
    }
    return finobaciNumbers
}