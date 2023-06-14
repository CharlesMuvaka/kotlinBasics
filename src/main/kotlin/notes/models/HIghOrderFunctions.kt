package notes.models

/*
                High Order Functions
        - These are functions that take in other functions as input parameters or return functions.

                Lambdas
        - These are functions that don't have a name.
 */

fun main() {
    var lamda = { a:Int, b: Int -> a + b }
    //highOrder(2,4,lamda)
    val bmi = {height: Double, weight: Double, age: Int -> (height * weight)/age}
    println(bmi(6.1,77.4, 26))

    //defining a lambda and assigning it to a variable
    val marks = {catMarks: Int, examMarks: Int -> catMarks + examMarks}
    println(calculateMarks(10,20, marks))
}

fun lambdas(){
    //initialising a variable to store a lambda expression

}
//defining a high order function that takes in a lambda as an argument
fun highOrder(a: Int, b: Int, weight: (Int, Int ) -> Int ){
    var result = weight(a, b)
    println("Result = $result")

}
//defining a high order function that takes in a lambda as an argument
fun calculateMarks(a:Int, b:Int, marks: (Int, Int) -> Int): Int{
    return marks(a, b)
}