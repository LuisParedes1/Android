// Exercise 1: https://developer.android.com/codelabs/basic-android-kotlin-compose-kotlin-fundamentals-practice-problems?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-2-pathway-1%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-kotlin-fundamentals-practice-problems#1


/*
    In the initial code provided in the following code snippet, write a program that prints the summary message based on the number of notifications that you received. The message should include:

    * The exact number of notifications when there are less than 100 notifications.
    * 99+ as the number of notifications when there are 100 notifications or more.
 */


fun main() {
    val morningNotification = 51
    val eveningNotification = 135
    
    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)
}


fun printNotificationSummary(numberOfMessages: Int) {
    
    val msg:String = when(numberOfMessages in 1..99){
        true -> "You have ${numberOfMessages.toString()} notifications."
        false -> "Your phone is blowing up! You have 99+ notifications."
    }
    
    println(msg)
}
