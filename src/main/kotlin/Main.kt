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
    names.drop(2) //drops the first element in the array
    names.dropLast(1) //drops the last element of the array

    for(name in names){
        println(name)
    }

}