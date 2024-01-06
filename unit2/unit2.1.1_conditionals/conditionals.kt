fun main(){
    // when expression
    val trafficLightColor = "Yellow"
        
    val action = when (trafficLightColor){
        "Red" -> "Stop"
        "Yellow" , "Amber" -> "Slow"
        "Green" -> "Go"
        else -> "Invalid traffic-light color"
    }

    println(action)

    val x = 3
    
    when (x) { 
        2,3,5,7 -> println("x is a prime number between 1 and 10.") // x == 2 or x == 3 or x == 5 or x == 7, prinln(...)
        else -> println("x isn't a prime number between 1 and 10.")
    }
}