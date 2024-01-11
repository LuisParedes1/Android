// Exercise 3: https://developer.android.com/codelabs/basic-android-kotlin-compose-kotlin-fundamentals-practice-problems?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-2-pathway-1%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-kotlin-fundamentals-practice-problems#3

/*
    In the initial code provided in the following code snippet, write a program that converts a temperature from one scale to another with these formulas:

    Celsius to Fahrenheit: ° F = 9/5 (° C) + 32
    Kelvin to Celsius: ° C = K - 273.15
    Fahrenheit to Kelvin: K = 5/9 (° F - 32) + 273.15 
 */

 fun main() {
    val initialMeasurementCelsius: Double = 27.0
    val initialMeasurementKelvin: Double = 350.0
    val initialMeasurementFahrenheit: Double = 10.0
    
    // Celsius to Fahrenheit
    printFinalTemperature(
    	initialMeasurementCelsius,
        "Celsius",
        "Fahrenheit")
    { // 9/5 (° C) + 32
        (9.toDouble()/5.toDouble() * it) + 32.toDouble()
    }
    
    // Kelvin to Celsius
    printFinalTemperature(
    	initialMeasurementKelvin,
        "Kelvin",
        "Celsius")
    { // K - 273.15
         it - 273.15
    }
    
    // Fahrenheit to Kelvin
    printFinalTemperature(
    	initialMeasurementFahrenheit,
        "Fahrenheit",
        "Kelvin")
    { // 5/9 (° F - 32) + 273.15
        5.toDouble()/9.toDouble() * (it - 32.toDouble()) + 273.15
    }
}

fun printFinalTemperature(
    initialMeasurement: Double, 
    initialUnit: String, 
    finalUnit: String, 
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}