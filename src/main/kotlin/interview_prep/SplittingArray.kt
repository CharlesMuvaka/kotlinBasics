package interview_prep

fun main(){
    val array = intArrayOf(1,0,0,0,0,1,1,1,1,0,1,1,1)
    val list = splitArray(array)
    println(array.size)
    for (i in list.indices){
        println(list[i])
    }

}
fun splitArray(array: IntArray): MutableList<MutableList<Int>> {

    //creating a list of integer lists to store the split array
    val numberList: MutableList<MutableList<Int>> = mutableListOf()

    if(array.isEmpty()){
        return numberList
    }

    //creating a mutable list to store the arrays
    var list = mutableListOf<Int>()
    list.add(array[0])

    for (i in 1 until array.size){
        if (array[i] == array[i -1]){
            list.add(array[i])
        }else{
            numberList.add(list)
            list = mutableListOf<Int>()
            list.add(array[i])

        }
    }
    numberList.add(list)

    return numberList
}