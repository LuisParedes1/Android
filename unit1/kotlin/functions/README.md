# Functions

```
fun sumNumbers(a:Int, b:Int): Int {
    return a+b
}

// Default arguments
fun printName(name: String = "Luis"){
    println(name)
}

fun main(){
    val x: Int = 10
    val y: Int = 2

    // Pase de argumentos
    println("The sum of $x + $y is ${sumNumbers(x,y)}")

    // Named arguments
    println("The sum of $x + $y is ${sumNumbers(a=x,b=y)}")

    // Puede inferir el tipo del argumento
    println("The sum of $x + $y is ${sumNumbers(a=10,b=2)}")

    // Print default
    printName()

    // Override default
    printName("Jose")
}
```

# Notion

More info in [Notion](https://mis-notas.notion.site/1-5-Functions-953b6fec30744880862a254a5541056e?pvs=4)
