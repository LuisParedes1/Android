// Exercise 5: https://developer.android.com/codelabs/basic-android-kotlin-compose-kotlin-fundamentals-practice-problems?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-2-pathway-1%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-kotlin-fundamentals-practice-problems#5

/*
    In the initial code provided in the following code snippet, write a program which prints out a person's profile details.
 */


 fun main() {    
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)
    
    amanda.showProfile()
    atiqah.showProfile()
}


class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
        println("Name: $name\nAge:$age\nLikes to $hobby. ${getRefInfo()} \n")
    }
    
    fun getRefInfo(): String{
        return if (referrer != null){
            "Has a referrer named ${referrer.name}, who likes to ${referrer.hobby}."
        }else{
            "Doesn't have a referrer."
        }
    }
}