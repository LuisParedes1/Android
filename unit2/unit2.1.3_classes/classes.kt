class SmartHouse{
        
    val name:String = "Smarty"

    fun greet(){
        println("Welcome")
    }

    fun turnOn(){
        println("TV on")
    }

    fun turnOff(){
        println("TV off")
    }
}

fun main() {
    val home: SmartHouse = SmartHouse()
    home.greet()
    home.turnOn()
}