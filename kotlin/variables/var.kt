fun main(){
    var name:String = "Luis" // var: variable that changes
    val edad:Int = 24 // val: value (defines a variable that changes)

    val varInCamelCase: String = "always"

    println("hello " + name + " you are: $edad years old")

    // Type inference
    // The compiler can infer variable tipe


    val edad1 = 2
    val edad2:Int = 2

    println("edad1 is the same as edad2: ${edad1 == edad2}")
}