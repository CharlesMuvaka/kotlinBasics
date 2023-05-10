package notes.models

class Student {
    //Testing about kotlin classess concepts
    var name: String? = null //initialized a member variable of text type. Cannot be accessed outside
    var studentId:Int? = 0
    var studentRegNumber: Int? = 0

    //initialise a nested class
    class Course{
       var courseName: String? = null
       val courseId:Int? = 0;
    }
}