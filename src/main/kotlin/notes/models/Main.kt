package notes.models

fun main(args: Array<String>) {
    //declaring ReadOnly variables - cannot be changed
    val firstName: String = "Charles"
    val lastName: String = "Muvaka"
    val middleName: String = "Muvkin"

    val names = arrayOf<String>(firstName,lastName, middleName) //creating an array of names

    //loping through the array
    for (name in names){
        println(name)
    }
    //getting the size of the array
    var size: Int = names.size
    var arraySize: Int = names.count();

    println((size == arraySize))

    //adding items in the array
    names[0] = "James"
    println(names[0])

    //dropping items in the array
    names.drop(2) //drops the first elements in the array
    names.dropLast(1) //drops the last element of the array

    for(name in names){
        println(name)
    }

    //initialising a student instance
    val studentOne = Student()
    studentOne.name = "charles";
    studentOne.studentId = 1
    studentOne.studentRegNumber = 33421748

    val studentTwo = Student()
    studentTwo.name = "ken"
    studentTwo.studentId = 2
    studentTwo.studentRegNumber = 32451876

    //creating an array of students
    val students: Array<Student> = arrayOf(studentOne, studentTwo)

    //looping through the student array
    for (student in students){
        println(student)
    }
    //destructuring a class
    //var(name, studentId) = studentOne

    for (i in 10 downTo 1 step 2){
        println(i);
    }

}