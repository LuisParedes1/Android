// Exercise 6: https://developer.android.com/codelabs/basic-android-kotlin-compose-kotlin-fundamentals-practice-problems?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-2-pathway-1%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-kotlin-fundamentals-practice-problems#6

/*

    In the initial code provided in the following code snippet, write a FoldablePhone class that inherits from the Phone class. 
    It should contain the following:

    A property that indicates whether the phone is folded.
    A different switchOn() function behavior than the Phone class so that it only turns the screen on when the phone isn't folded.
    Methods to change the folding state.
 */

open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }
    
    fun switchOff() {
        isScreenLightOn = false
    }
    
    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(var isFolded: Boolean): Phone (isScreenLightOn = !isFolded) {
    
    override fun switchOn() {
        if (!isFolded){
            super.switchOn()
        }
    }
    
    fun setFoldingState(){
        isFolded = !isFolded
    }
    
}

fun main(){
    val foldable: FoldablePhone = FoldablePhone(isFolded=true)
    
    foldable.checkPhoneScreenLight()
}