fun main(){

    // To declare nullable variables in Kotlin, you need to add a ? operator to the end of the type.
    var favoriteActor: String? = "Jacky Shan"
    println(favoriteActor)

    favoriteActor = null
    prinln(favoriteActor)

    var favoriteNumber:Int? = 1
    println(favoriteNumber)
    
    favoriteNumber = null
    println(favoriteNumber)

    // Access properties of nullable var with ?.

    // Non-nullable variable
    var favoriteActor:String = "Jacky Shan"
    println(favoriteActor.length)

    // Nullable variable
    var favoriteActor:String? = "Jacky Shan"
    println(favoriteActor?.length)
    println(favoriteActor!!.length)

    favoriteActor = null
    println(favoriteActor?.length)

    if (favoriteActor != null){
        println(favoriteActor.length)
    }


    // if-else expressions
    var favoriteActor:String? = "Jacky Shan"
    
    val lenght: Int = if (favoriteActor != null){
        favoriteActor.length
    }else{
        0
    }
    
    println(lenght)    


    // ?: Elvis operator

     var favoriteActor:String? = "Jacky Shan"
     val length = favoriteActor?.length ?: 0

     println(lenght)
}