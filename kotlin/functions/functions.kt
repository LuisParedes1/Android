// Declare function
fun printSomethingNew(){
    println("Another thing")
}

// Declara funtion with param and return type
fun sumNumbers(a:Int, b:Int): Int {
    return a+b
}

fun birthdayGreeting(): String {
    val nameGreeting = "Happy Birthday, Rover!"
    val ageGreeting = "You are now 5 years old!"
    return "$nameGreeting\n$ageGreeting"
}


// Default arguments
fun printName(name: String = "Luis"){
	println(name)
}

fun main() {
    println("Functions in Kotlin")

    printSomethingNew()

    val x: Int = 10
    val y: Int = 2
    println("The sum of $x + $y is ${sumNumbers(x,y)}")

    // Named arguments
    println("The sum of $x + $y is ${sumNumbers(a=x,b=y)}")
    
    // Puede inferir el tipo del argumento
    println("The sum of $x + $y is ${sumNumbers(a=10,b=2)}")

    // Print a String from a function
    println(birthdayGreeting())

    // Print default
	printName()

	// Override default
	printName("Jose")
}
