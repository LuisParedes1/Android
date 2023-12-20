fun main(){
    var edad:Int = 20 // var: variable that changes
    val name:String = "Luis"  // val: value (defines a variable that doesn't change it's value)

    val varInCamelCase: String = "always"

    println("hello " + name + " you are: $edad years old")

    edad += 1
    println("hello " + name + " you are: $edad years old")

    edad++
    println("hello " + name + " you are: $edad years old")

    // Type inference
    // The compiler can infer variable tipe
    val edad1 = 2
    val edad2:Int = 2

    println("edad1 is the same as edad2: ${edad1 == edad2}")

    // Other variable types

    val newName: String = "Luis"
    val gpa: Double = 10.0
    val age: Int = 24
    val isHandsome: Boolean = true

    println("Hello my name is $newName, I am $age years old, my GPA is $gpa and I am handsome $isHandsome")


    // You can also concatenate variables of other data types like Int and Boolean to Strings
    println("Hello my name is " + newName + " I am " + age + " years old, my GPA is " + gpa + " and I am handsome " + isHandsome)
}