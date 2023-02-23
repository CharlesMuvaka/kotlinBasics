
fun main(){
    val test1: String = "pf41890"
    val test2: String = "sn41890"
    val test3 = test1.subSequence(0,3)
    if(test3 == test2.subSequence(0,3)){
        println("We are getting somewhere.")
    }else{
        println("I have to work harder.")
    }
}